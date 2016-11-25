package com.suhailkandanur.eopi.ch11;

import com.suhailkandanur.eopi.util.RandomGen;

/**
 * Problem: 11.1 - Design an algorithm that takes as set of files containing stock trades sorted by increasing trade times,
 * and write a single file contianing the trades appearing in the individual files sorted in the same order. The algorithm
 * should use very little RAM, ideally of the order of a few kilobytes.
 * <p>
 * Created by suhail on 2016-11-25.
 */
public class MergeSortedFilesP11_1 {
    //this will implement merge sort on a array of integers

    public static int[] mergeSort(int[] unsorted) {
        if(unsorted == null || unsorted.length < 1)
            return unsorted;
        int[] sortedArray = new int[unsorted.length];
        sort(unsorted, sortedArray, 0, unsorted.length -1);
        return sortedArray;
    }

    public static void sort(int[] actualArray, int[] sortedArray, int lo, int hi) {
        if(lo >= hi) {
            return;
        }

        int mid = lo + ((hi - lo)/2);

        sort(actualArray, sortedArray, lo, mid);
        sort(actualArray, sortedArray, mid + 1, hi);
        merge(actualArray, sortedArray, lo, mid, hi);
    }

    public static void merge(int [] actualArray, int[] sortedArray, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        while (i <= mid && j <= hi) {

        }
    }

    public static void main(String[] args) {
        int[] unsortedIntArray = RandomGen.generateRandom(100);
        for (int i = 0; i < unsortedIntArray.length; i++) {
            System.out.println(unsortedIntArray[i]);
        }

        int[] sortedArray = mergeSort(unsortedIntArray);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }
}
