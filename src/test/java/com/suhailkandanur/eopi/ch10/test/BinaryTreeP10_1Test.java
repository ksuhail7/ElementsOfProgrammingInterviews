package com.suhailkandanur.eopi.ch10.test;

import com.suhailkandanur.eopi.util.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static com.suhailkandanur.eopi.ch10.BinaryTreeP10_1.createTree;
import static com.suhailkandanur.eopi.ch10.BinaryTreeP10_1.height;
import static com.suhailkandanur.eopi.ch10.BinaryTreeP10_1.isTreeBalanced;
import static org.junit.Assert.assertTrue;

/**
 * Created by suhail on 2016-11-03.
 */
public class BinaryTreeP10_1Test {
    private TreeNode binaryTree;

    @Before
    public void setupTree() {
        int[] array = {5,2,1,7,6,9,8};
        binaryTree = createTree(array);
    }

    @Test
    public void testHeight() {
        System.out.println(height(binaryTree));
    }

    @Test
    public void testIsBalancedTree() {
        assertTrue(isTreeBalanced(binaryTree));
    }
}
