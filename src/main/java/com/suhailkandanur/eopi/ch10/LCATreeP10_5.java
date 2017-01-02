package com.suhailkandanur.eopi.ch10;

import com.suhailkandanur.eopi.ch9.TreeTraverseP9_10;
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
        ArrayUtils.printArray(array);
        // BinarySearchTree.traverseInOrderBST(root);
        TreeTraverseP9_10.traverseAndPrint(root);
        TreeNode ptr1 = BinarySearchTree.findElement(root, array[randomElements[0]]);
        TreeNode ptr2 = BinarySearchTree.findElement(root, array[randomElements[1]]);
        System.out.println("Element 1: " + ptr1.getData() + ", " + array[randomElements[0]]);
        System.out.println("Element 2: " + ptr2.getData() + ", " + array[randomElements[1]]);
        TreeNode lca = LCA(ptr1, ptr2);
        if (lca != null)
            System.out.println("LCA : " + lca.getData());
        else
            System.err.println("LCA not found");
    }

    private static TreeNode LCA(TreeNode node1, TreeNode node2) {
        TreeNode lca = null;
        int heightOfNode1 = height(node1);
        int heightOfNode2 = height(node2);
        System.out.println("Heights " + heightOfNode1 + ", " + heightOfNode2);
        TreeNode ptr1 = null, ptr2 = null;
        if (heightOfNode1 > heightOfNode2) {
            ptr1 = node1;
            ptr2 = node2;
        } else {
            ptr1 = node2;
            ptr2 = node1;
        }
        int heightDiff = Math.abs(heightOfNode1 - heightOfNode2);
        while (ptr1 != null && heightDiff > 0) {
            ptr1 = ptr1.getParent();
            heightDiff--;
        }
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.getData() == ptr2.getData()) {
                lca = ptr1;
                break;
            }
            ptr1 = ptr1.getParent();
            ptr2 = ptr2.getParent();
        }
        return lca;
    }

    private static int height(TreeNode node) {
        TreeNode ptr = node;
        int height = 0;
        while(ptr != null) {
            height++;
            ptr = ptr.getParent();
        }
        return height - 1;
    }
}
