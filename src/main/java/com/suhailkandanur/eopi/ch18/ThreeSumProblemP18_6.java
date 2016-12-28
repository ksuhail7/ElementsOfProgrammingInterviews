package com.suhailkandanur.eopi.ch18;

import com.suhailkandanur.eopi.util.ArrayUtils;

/**
 * Created by suhail on 2016-12-22.
 */
public class ThreeSumProblemP18_6 {
    public static int kCreate(int[] array, int t, int k) {
        if (array == null || array.length < 1 || k < 1 || k > array.length)
            return -1;

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            int diff = (i - k) >= 0 ? array[i - k] : 0;
            sum = sum - diff;
            if (sum == t)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 3, 4, 3};
        int firstIndex = kCreate(array, 9, 3);
        ArrayUtils.printArray(array);
        System.out.println("first index: " + firstIndex);
        System.out.println("done");
    }
}
