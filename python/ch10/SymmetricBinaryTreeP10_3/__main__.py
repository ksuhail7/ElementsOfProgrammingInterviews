#!/usr/bin/env python3

from tree import BinaryTree

# array = [random.randint(0, 100) for x in range(0, 10)]
array = [314, 6, 6, -1, 2, 2, -1, -1, -1, -1, 3, 3, -1]
print(array)
bst = BinaryTree(array)
bst.inorder_traversal()
print(bst.is_symmetric())

os.path
