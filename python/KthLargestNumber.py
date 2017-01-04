#!/usr/bin/env python3

import random

"""
lo to large-1 : numbers > k
large to equals - 1: numbers == k
equals to small: unknown
small+1 to hi : numbers < k
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
		if array[equals] > k:
			temp = array[large]
			array[large] = array[equals]
			array[equals] = temp
			equals+=1
			large+=1
		elif array[equals] == k:
			equals+=1
		elif array[equals] < k:
			temp = array[small]
			array[small] = array[equals]
			array[equals] = temp
			small-=1

	return large

def find_k_th_largest(array, lo, hi, k):
	print(array, "lo", lo, "hi", hi, "k", k)
	if lo > hi:
		return -1
	random_k = random.randint(lo, hi)
	print("random", array[random_k])
	split = partition_array(array, lo, hi, array[random_k])
	print("split", split)
	if split+1 == k:
		return split
	elif split+1 > k:
		return find_k_th_largest(array, lo, split - 1, k)
	elif split+1 < k:
		#split = 1
		#k = 3
		#lo = k - split
		return find_k_th_largest(array, split + 1, hi, k)

size = 10
min = 0
max = 100

array = [random.randint(0, 100) for x in range(0, size)]
arr_length = len(array)
k = 3

print(array)
kth = find_k_th_largest(array, 0, len(array)-1, k)
print(array, "kth", kth)
print("kth largest", array[kth])