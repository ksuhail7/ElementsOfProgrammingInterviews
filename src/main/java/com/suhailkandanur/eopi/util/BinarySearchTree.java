package com.suhailkandanur.eopi.util;

/**
 * Created by suhail on 2017-01-01.
 */
public interface BinarySearchTree {
    static TreeNode constructBST(int[] array) {
        TreeNode root = null;
        for (int i = 0; array != null && i < array.length; i++) {
            int element = array[i];
            TreeNode newNode = new TreeNode(element);
            if(root == null) {
                root = newNode;
                continue;
            }
            TreeNode ptr = root;
            while(ptr != null) {
                int data = ptr.getData();
                if(element <= data) {
                    if(ptr.getLeft() == null) {
                        ptr.setLeft(newNode);
                        break;
                    } else {
                        ptr = ptr.getLeft();
                    }
                } else {
                    if(ptr.getRight() == null) {
                        ptr.setRight(newNode);
                        break;
                    } else {
                        ptr = ptr.getRight();
                    }
                }
            }
        }
        return root;
    }

    static void traverseInOrderBST(TreeNode root) {
        traverseInOrderBSTHelper(root);
        System.out.println();
    }

    static void traverseInOrderBSTHelper(TreeNode root) {
        if(root == null) {
            return;
        }
        traverseInOrderBSTHelper(root.getLeft());
        System.out.print(root.getData()+ ", ");
        traverseInOrderBSTHelper(root.getRight());
    }
}
