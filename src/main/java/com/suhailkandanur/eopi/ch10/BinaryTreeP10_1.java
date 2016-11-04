package com.suhailkandanur.eopi.ch10;

import com.suhailkandanur.eopi.util.TreeNode;

import static com.suhailkandanur.eopi.ch15.BSTP15_1.createBST;
import static jdk.nashorn.internal.objects.NativeMath.abs;

/**
 * Created by suhail on 2016-11-03.
 */
public class BinaryTreeP10_1 {
    public static TreeNode createTree(int[] array) {
        return createBST(array);
    }

    public static boolean isTreeBalanced(TreeNode root) {
        return height(root) != -2;
    }

    public static int height(TreeNode root) {
        if (root == null)
            return -1;
        int heightOfLeft = height(root.getLeft());
        int heightOfRight =  height(root.getRight());
        if(heightOfLeft == -2 || heightOfRight == -2)
            return -2;
        if (Math.abs(heightOfLeft - heightOfRight) > 1.0)
            return -2;
        else
            return Math.max(heightOfLeft, heightOfRight) + 1 ;
    }


}
