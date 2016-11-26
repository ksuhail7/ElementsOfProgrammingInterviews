package com.suhailkandanur.eopi.ch11;

import com.suhailkandanur.eopi.util.ArrayUtils;
import com.suhailkandanur.eopi.util.RandomGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem: 11.1 - Design an algorithm that takes as set of files containing stock trades sorted by increasing trade times,
 * and write a single file contianing the trades appearing in the individual files sorted in the same order. The algorithm
 * should use very little RAM, ideally of the order of a few kilobytes.
 * <p>
 * Created by suhail on 2016-11-25.
 */
public class MergeSortedFilesP11_1 {
    private static final Logger logger = LoggerFactory.getLogger(MergeSortedFilesP11_1.class);
    //this will implement merge sort on a array of integers

    public static int[] mergeSort(final int[] unsorted) {
        if (unsorted == null || unsorted.length < 1)
            return unsorted;
        int[] sortedArray = new int[unsorted.length];
        //copy elements into sorted array
        for (int i = 0; i < unsorted.length; i++) {
            sortedArray[i] = unsorted[i];
        }
        sort(sortedArray, 0, unsorted.length - 1);
        return sortedArray;
    }

    public static void sort(int[] actualArray, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + ((hi - lo) / 2);
        //logger.info("sorting (lo: {}, mid: {})", lo, mid);
        sort(actualArray, lo, mid);
        //logger.info("sorting (mid + 1: {}, hi; {})" , mid + 1 , hi);
        sort(actualArray, mid + 1, hi);
//        logger.info("Merging (lo: {}, mid: {}, hi: {})", lo, mid, hi);
        merge(actualArray, lo, mid, hi);
    }

    public static void merge(int[] actualArray, int lo, int mid, int hi) {
        if (lo >= hi) {
            return;
        }
        int len = hi - lo + 1;
        int[] temp = new int[len];
        int i = lo;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= hi) {
            if (actualArray[i] >= actualArray[j]) {
                temp[count] = actualArray[j++];
            } else {
                temp[count] = actualArray[i++];
            }
            count++;
        }
        while (i <= mid) temp[count++] = actualArray[i++];
        while (j <= hi) temp[count++] = actualArray[j++];
        //copy into actualArray
        for (int k = 0; k < len; k++) {
            actualArray[lo + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] unsortedIntArray = RandomGen.generateRandom(20, 200);
        ArrayUtils.printArray(unsortedIntArray);
        int[] sortedArray = mergeSort(unsortedIntArray);
        ArrayUtils.printArray(sortedArray);
    }

}
