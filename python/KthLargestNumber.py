#!/usr/bin/env python3

import random

"""
lo to large-1 : numbers > k
large to equals - 1: numbers == k
equals to small: unknown
small+1 to hi : numbers > k
"""
def partition_array(array, lo, hi, k):
	split = -1
	arr_length = len(array)
	if array is None or lo > hi or lo < 0 or hi >= len(array):
		return split
	large = lo
	equals = lo
	small = hi

	while equals <= small:
		print("hello")




size = 10
min = 0
max = 100

array = [random.randint(0, 100) for x in range(0, size)]

k = 3

print(array)