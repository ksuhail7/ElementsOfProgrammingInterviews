package com.suhailkandanur.eopi.ch15.test;

import com.suhailkandanur.eopi.ch15.BSTP15_1;
import com.suhailkandanur.eopi.util.RandomGen;
import com.suhailkandanur.eopi.util.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static com.suhailkandanur.eopi.ch15.BSTP15_1.BFS;
import static com.suhailkandanur.eopi.ch15.BSTP15_1.DFS;
import static com.suhailkandanur.eopi.ch15.BSTP15_1.isBST;
import static org.junit.Assert.assertEquals;

/**
 * Created by suhail on 2016-11-03.
 */
public class BSTP15_1Test {
    private TreeNode bstRoot;
    @Before
    public void setupBST() {
        int[] inputArray = RandomGen.generateRandom(10);
        bstRoot = BSTP15_1.createBST(inputArray);
        DFS(bstRoot);
        System.out.println("---");
        BFS(bstRoot);
    }

    @Test
    public void testIsBST() {
        assertEquals(true, isBST(bstRoot));
    }
}
