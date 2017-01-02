package com.suhailkandanur.eopi.ch9;

import com.suhailkandanur.eopi.util.ArrayUtils;
import com.suhailkandanur.eopi.util.BinaryTree;
import com.suhailkandanur.eopi.util.RandomGen;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by suhail on 2016-12-29.
 */
public class TreeTraverseP9_10 {

    public static void main(String[] args) {
        int[] binaryTree = RandomGen.generateRandom(15, 0, 200);
        Queue<Integer> queue = new LinkedList<>();
        ArrayUtils.printArray(binaryTree);
        queue.add(0);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(node >=0 && node < binaryTree.length) {
                System.out.println(binaryTree[node]);
                int left = BinaryTree.leftNode(node);
                int right = BinaryTree.rightNode(node);
                queue.add(left);
                queue.add(right);
            }
        }

    }
}
