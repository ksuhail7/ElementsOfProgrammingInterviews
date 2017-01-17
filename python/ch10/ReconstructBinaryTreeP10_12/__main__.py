#!/usr/bin/env python3

from tree import BinaryTree
from node import TreeNode
import random

def reconstruct_tree(inorder, preorder):
    if inorder is None or preorder is None or len(inorder) < 1 or len(preorder) < 1:
        return None
    current = preorder[0]

    inorder_left = []
    preorder_left = []
    for i in range(0, len(inorder)):
        if inorder[i] == current:
            break
        inorder_left.append(inorder[i])
        preorder_left.append(preorder[i+1])

    inorder_right = []
    preorder_right = []
    for j in range(i+1, len(inorder)):
        inorder_right.append(inorder[j])
        preorder_right.append(preorder[j])

    root = TreeNode(preorder[0])
    root.set_left(reconstruct_tree(inorder_left, preorder_left))
    root.set_right(reconstruct_tree(inorder_right, preorder_right))
    return root

def main():
#    array = [314, 6, 6, -1, 2, 2, -1, -1, -1, -1, 3, 3, -1]

    array = [random.randint(0, 100) for x in range(0, 10)]

    bt = BinaryTree(array)
    inorder = bt.inorder()
    print(inorder)
    print(bt.preorder())
    print(bt.postorder())

    root = reconstruct_tree(bt.inorder(), bt.preorder())
    print("after reconstruction")
    print(BinaryTree.inorder_helper(root))
    print(BinaryTree.preorder_helper(root))
    print(BinaryTree.postorder_helper(root))

if __name__ == '__main__':
    main()
