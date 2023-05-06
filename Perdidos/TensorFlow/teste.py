import tensorflow as tf
import pandas as pd

features = {
	'sales' : [[5],[10],[8],[9]],
	'department' : ['sports', 'sports', 'gardening', 'gardening']}
	
department_column = tf.feature_column.categorical_column_with_vocabulary_list(
	'department', ['sports', 'gardening'])

department_column = tf.feature_column.indicator_column(department_column)

columns = [
	tf.feature_column.numeric_column('sales'),
	department_column
]

inputs = tf.feature_column.input_layer(features, columns)

var_init = tf.global_variables_initializer()
table_init = tf.tables_initializer()

sess = tf.Session()
sess.run((var_init,table_init))

print(sess.run(inputs))