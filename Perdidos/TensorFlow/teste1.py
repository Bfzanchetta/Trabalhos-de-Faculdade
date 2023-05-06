import tensorflow as tf
import pandas as pd


x = tf.constant([[1], [2], [3], [4]], dtype=tf.float32)

y_true = tf.constant([[0], [-1], [-2], [-3]], dtype=tf.float32)

linear_model = tf.layers.Dense(units=1)
y_pred = linear_model(x)

sess = tf.Session()
init = tf.global_variables_initializer()
sess.run(init)

print(sess.run(y_pred))