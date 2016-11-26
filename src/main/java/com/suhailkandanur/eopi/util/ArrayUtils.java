package com.suhailkandanur.eopi.util;

/**
 * Created by suhail on 2016-11-25.
 */
public class ArrayUtils {

    public static void printArray(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}
