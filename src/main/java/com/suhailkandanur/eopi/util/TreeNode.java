package com.suhailkandanur.eopi.util;

/**
 * Created by suhail on 2016-11-03.
 */
public class TreeNode {
    int data;
    TreeNode left, right, parent;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}

