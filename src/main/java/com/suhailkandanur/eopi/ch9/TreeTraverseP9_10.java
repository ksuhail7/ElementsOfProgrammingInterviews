package com.suhailkandanur.eopi.ch9;

import com.suhailkandanur.eopi.util.ArrayUtils;
import com.suhailkandanur.eopi.util.BinarySearchTree;
import com.suhailkandanur.eopi.util.RandomGen;
import com.suhailkandanur.eopi.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by suhail on 2016-12-29.
 */
public class TreeTraverseP9_10 {

    public static void main(String[] args) {
        int[] binaryTree = RandomGen.generateRandom(15, 0, 200);
        ArrayUtils.printArray(binaryTree);
        TreeNode root = BinarySearchTree.constructBST(binaryTree);
        BinarySearchTree.traverseInOrderBST(root);
        traverseAndPrint(root);
    }

    public static void traverseAndPrint(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode separator = new TreeNode(-1);
        queue.add(root);
        queue.add(separator);
        while(!queue.isEmpty()) {
            while(queue.peek() != separator) {
                TreeNode node = queue.poll();
                System.out.print(node.getData() + " ");
                TreeNode left = node.getLeft();
                TreeNode right = node.getRight();
                if(left != null)
                    queue.add(left);
                if(right != null)
                    queue.add(right);
            }
            queue.poll(); //remove separator
            System.out.println();
            if(!queue.isEmpty()) {
                queue.add(separator);
            }
        }
    }
}
