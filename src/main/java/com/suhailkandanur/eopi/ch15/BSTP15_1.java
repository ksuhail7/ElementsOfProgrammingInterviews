package com.suhailkandanur.eopi.ch15;

/**
 * Created by suhail on 2016-11-03.
 */
public class BSTP15_1 {
    public static class BSTNode {
        int data;
        BSTNode left, right;

        public BSTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return data;
        }

        public BSTNode getLeft() {
            return left;
        }

        public BSTNode getRight() {
            return right;
        }

        public void setLeft(BSTNode left) {
            this.left = left;
        }

        public void setRight(BSTNode right) {
            this.right = right;
        }
    }

    public static boolean isBST(BSTNode root) {
        if(root == null)
            return true;
        BSTNode leftNode = root.getLeft();
        BSTNode rightNode = root.getRight();

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

    public static BSTNode createBST(int[] array) {
        BSTNode root = null;
        for (int i = 0; i < array.length; i++) {
            int data = array[i];
            root = createBST(root, data);
        }
        return root;
    }

    private static BSTNode createBST(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
        } else if(root.getData() > value) {
            root.setLeft(createBST(root.getLeft(), value));
        } else if(root.getData() <= value) {
            root.setRight(createBST(root.getRight(), value));
        }
        return root;
    }

    public static void DFS(BSTNode root) {
        if(root == null)
            return;
        DFS(root.getLeft());
        DFS(root.getRight());
        System.out.println(root.getData());
    }

    public static void BFS(BSTNode root) {
        if (root == null) {
            return;
        }
        BFS(root.getLeft());
        System.out.println(root.getData());
        BFS(root.getRight());
    }


}
