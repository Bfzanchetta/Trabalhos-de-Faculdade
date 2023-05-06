# -*- coding: cp1252 -*-
#Bibliotecas
import tensorflow as tf
from tensorflow.contrib import rnn
import numpy as np
import pandas as pd

#Importar dados do MNIST
from tensorflow.examples.tutorials.mnist import input_data
mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)

#Parâmetros do Aprendizado em Batch
learning_rate = 0.001
training_iters = 100000
batch_size = 128
display_step = 50
num_train = mnist.train.num_examples
num_batches = (num_train//batch_size)+1
epochs = 2

#Parâmetros da Rede RNN LSTM
n_input = 28 # dado de input do MNIST (formato da imagem:28x28)
n_steps = 28 # pois cada ht possui uma fatia columnar do dado, i.e., uma coluna de 28
n_hidden = 128 # numero de features da hidden layer
n_classes = 10 # numero de features de saída - os dígitos 0,1,...,9

#Definindo a função forward pass ('passe adiante') da RNN
def RNN(x, weights, biases):

	#Desempilhando para pegar a lista de 'n_stepstensors' de formato (batch_size, n_input) 
	x = tf.unstack(x, n_steps, 1)

	#Definindo uma LSTM
	lstm_cell = rnn.BasicLSTMCell(n_hidden, forget_bias=1.0)

	#Pegar o output da célula LSTM
	outputs, states = rnn.static_rnn(lstm_cell, x, dtype=tf.float32)

	#Ativação Linear, usando o loop interno do último output da RNN
	return tf.matmul(outputs[-1], weights['out']) + biases['out']

#Grafo de input do TensorFlow
x = tf.placeholder("float", [None, n_steps, n_input])
y = tf.placeholder("float",[None, n_classes])

#Definindo pesos
weights = {
	'out' : tf.Variable(tf.random_normal([n_hidden,n_classes]))	
	}
biases = {
	'out' : tf.Variable(tf.random_normal([n_classes]))
	}
				
pred = RNN(x, weights, biases)

#Definindo a função perda 'loss' e o otimizador desta
cost = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(logits=pred, labels=y))
optimizer = tf.train.AdamOptimizer(learning_rate=learning_rate).minimize(cost)

#Validar o modelo
correct_pred = tf.equal(tf.argmax(pred,1), tf.argmax(y,1))
accuracy = tf.reduce_mean(tf.cast(correct_pred, tf.float32))

#Inicializando as variáveis
init = tf.global_variables_initializer()
						
#Rodando a sessão
with tf.Session() as sess:
	sess.run(init)
	i = 0
	
	while i < epochs:
		for step in xrange(num_batches):
			batch_x, batch_y = mnist.train.next_batch(batch_size)
			batch_x = batch_x.reshape((batch_size,n_steps,n_input))
		#Rodar operação de otimização or backpropagation
			sess.run(optimizer, feed_dict={x:batch_x, y:batch_y})
			if (step+1) % display_step == 0:
				acc = sess.run(accuracy, feed_dict={x:batch_x, y:batch_y})
				loss = sess.run(cost, feed_dict={x:batch_x, y:batch_y})
				print "Epoch: " + str(i+1) + ", step: " + str(step+1) + ",Minibatch loss:" + "\{:.6f}".format(loss) + ",Training Accuracy: " + "\{:.5f}".format(acc)
				
		i += 1
	print "Optimization Finished!"

	#Calcular precisão
	test_len = 500
	test_data = mnist.test.images[:test_len].reshape((-1,n_steps,n_input))
	test_label = mnist.test.labels[:test_len]
	print "Testing Accuracy:", sess.run(accuracy, feed_dict={x: test_data, y: test_label})