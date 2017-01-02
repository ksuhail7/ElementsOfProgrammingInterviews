package com.suhailkandanur.eopi.util;

/**
 * Created by suhail on 2016-12-29.
 */
public interface BinaryTree {
    static int leftNode(int i) {
        return 2 * i + 1;
    }

    static int rightNode(int i) {
        return 2 * (i + 1);
    }
}
