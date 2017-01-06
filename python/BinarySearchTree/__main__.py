#!/usr/bin/env python3

import random

from binarysearchtree import BinarySearchTree

min = 0
max = 100
size = 10
array = [random.randint(min, max) for x in range(0, size)]
print(array)
bst = BinarySearchTree()

for element in array:
    bst.add(element)

elementToFind = array[random.randint(0, len(array) - 1)]
node = bst.find(elementToFind)
keyLargerThanK = bst.keyLargerThanK(elementToFind)
if node is not None:
    print(node.getData())
    if keyLargerThanK is not None:
        print("key larger than " + str(elementToFind) + " : " + str(keyLargerThanK.getData()))
    else:
        print("larger element not found")
else:
    print(str(elementToFind) + " not found")
