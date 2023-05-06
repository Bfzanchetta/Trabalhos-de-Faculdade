from __future__ import absolute_import
from __future__ import division
from __future__ import print_function

import numpy as np
import tensorflow as tf
import csv

tf.logging.set_verbosity(tf.logging.INFO)



def cnn_model_fn(features, labes, mode):
	input_layer = tf.reshape(features["x"], [-1, 28, 28, 1])
	
	conv1 = tf.layers.conv2d(
		inputs=input_layer,
		filters=32,
		kernel_size=[5, 5],
		padding="same",
		activation=tf.nn.relu)
	
	
	
if __name__ == "__main__":
  tf.app.run()