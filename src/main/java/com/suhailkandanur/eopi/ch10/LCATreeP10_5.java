package com.suhailkandanur.eopi.ch10;

import com.suhailkandanur.eopi.util.ArrayUtils;
import com.suhailkandanur.eopi.util.BinarySearchTree;
import com.suhailkandanur.eopi.util.RandomGen;
import com.suhailkandanur.eopi.util.TreeNode;

/**
 * Created by suhail on 2017-01-01.
 */
public class LCATreeP10_5 {
    public static void main(String[] args) {
        int[] array = RandomGen.generateRandom(15, 0, 100);
        TreeNode root = BinarySearchTree.constructBSTwithParentPtr(array);
        // pick two random elements in array
        int[] randomElements = RandomGen.generateRandom(2, 0, array.length - 1);
        ArrayUtils.printArray(randomElements);
        BinarySearchTree.traverseInOrderBST(root);
        TreeNode ptr1 = BinarySearchTree.findElement(root, array[randomElements[0]]);
        TreeNode ptr2 = BinarySearchTree.findElement(root, array[randomElements[1]]);
        System.out.println(ptr1.getData() + ", " + array[randomElements[0]]);
        System.out.println(ptr2.getData() + ", " + array[randomElements[1]]);
        LCA(ptr1, ptr2);
    }

    private static TreeNode LCA(TreeNode node1, TreeNode node2) {
        TreeNode lca = null;
        int heightOfNode1 = height(node1);
        int heightOfNode2 = height(node2);
        System.out.println(heightOfNode1 + ", " + heightOfNode2);
        return lca;
    }

    private static int height(TreeNode node) {
        TreeNode ptr = node;
        int height = 0;
        while(ptr != null) {
            height++;
            ptr = ptr.getParent();
        }
        return height;
    }
}
