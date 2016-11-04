package com.suhailkandanur.eopi.ch15;

import com.suhailkandanur.eopi.util.TreeNode;

/**
 * Created by suhail on 2016-11-03.
 */
public class BSTP15_1 {

    public static boolean isBST(TreeNode root) {
        if(root == null)
            return true;
        TreeNode leftNode = root.getLeft();
        TreeNode rightNode = root.getRight();

        if(leftNode != null) {
            if(root.getData() < leftNode.getData())
                return false;
        }

        if(rightNode != null) {
            if(root.getData() > rightNode.getData())
                return false;
        }
        return isBST(leftNode) && isBST(rightNode);
    }

    public static TreeNode createBST(int[] array) {
        TreeNode root = null;
        for (int i = 0; i < array.length; i++) {
            int data = array[i];
            root = createBST(root, data);
        }
        return root;
    }

    private static TreeNode createBST(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else if(root.getData() > value) {
            root.setLeft(createBST(root.getLeft(), value));
        } else if(root.getData() <= value) {
            root.setRight(createBST(root.getRight(), value));
        }
        return root;
    }

    public static void DFS(TreeNode root) {
        if(root == null)
            return;
        DFS(root.getLeft());
        DFS(root.getRight());
        System.out.println(root.getData());
    }

    public static void BFS(TreeNode root) {
        if (root == null) {
            return;
        }
        BFS(root.getLeft());
        System.out.println(root.getData());
        BFS(root.getRight());
    }


}
