#!/usr/bin/env python3
import random
import sys


def genRandomArray(size, min, max):
    x = [random.randint(min, max) for x in range(0, size)]
    return x


def partitionArray(array, pivot):
    small = 0
    equals = 0
    large = len(array) - 1

    while equals <= large:
        """ print("small", small, "equals", equals, "large", large) """
        """print(array)"""
        if array[equals] < pivot:
            temp = array[small]
            array[small] = array[equals]
            array[equals] = temp
            small+=1
            equals+=1
        elif array[equals] == pivot:
            equals+=1
        elif array[equals] > pivot:
            temp = array[large]
            array[large] = array[equals]
            array[equals] = temp
            large-=1
    return small


def quickSort(array):
    quickSortHelper(array, 0, len(array)-1)

def quickSortHelper(array, lo, hi):
    if lo >= hi:
        return
    pivot = array[hi]
    #print("pivot", pivot)
    split = partitionArray(array, pivot)
    quickSortHelper(array, lo, split-1)
    quickSortHelper(array, split+1, hi)

sys.setrecursionlimit(25000)
array = genRandomArray(30, 0, 200000)
#pivot = array[genRandomArray(1, 0, len(array))[0]]
#print(array, pivot)
#partitionArray(array, pivot)
print(array)
quickSort(array)
print(array)
print("hello")
