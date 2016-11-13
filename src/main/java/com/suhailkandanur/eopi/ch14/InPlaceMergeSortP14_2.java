package com.suhailkandanur.eopi.ch14;

/**
 * Write a function wihch takes as input two sorted arrays of integers A and B,
 * and updates A to the combined entries of A and B in sorted order.
 * Assume A has enough empty entires at its end to hold the result.
 *
 * Created by suhail on 2016-11-13.
 */
public class InPlaceMergeSortP14_2 {
    public static void inPlaceMergeSort(int[] A, int[] B, int lenA, int lenB) {
        if(A == null || B == null)
            return;
        int ptrA = lenA - 1;
        int ptrB = lenB - 1;
        int ptrSort = A.length - 1;
        while(ptrSort >= 0) {
            System.out.println("pSort: " + ptrSort + ", ptrA: " + ptrA + ", ptrB: " + ptrB);
            if(ptrB < 0 || (ptrA >= 0 && A[ptrA] > B[ptrB])) {
                A[ptrSort--] = A[ptrA--];
            } else if(ptrA < 0 || (ptrB >= 0 && A[ptrA] <= B[ptrB])) {
                A[ptrSort--] = B[ptrB--];
            }
        }

    }

    public static void main(String[] args) {
        int[] B = new int[] {0, 4, 4};
        int[] A = new int[] {1,3,4,6, 0, 0, 0};
        inPlaceMergeSort(A, B, 4, 3);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ",");
        }
        System.out.printf("");
    }
}
