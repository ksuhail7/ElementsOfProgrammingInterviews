package com.suhailkandanur.eopi.ch14;

/**
 * Created by suhail on 2016-11-13.
 */

/**
 * Problem 14.1: Given two sorted arrays A and B of lengths n and m respectively.
 * Return an array C containing elements common to A and B. The array C should be
 * free to duplicates. How would you perform this intersection if
 * 1. n ~ m
 * 2. n << m
 */
public class SortingP14_1 {
    public static void main(String[] args) {
        int[] A = new int[] {1, 3, 5, 6, 7};
        int[] B = new int[] {1, 3, 5, 6, 7};
        int[] C = intersection(A, B);
        for (int i = 0; C != null && i < C.length; i++) {
            System.out.print(C[i] + ", ");
        }
        System.out.println("");
    }

    public static int[] intersection(int[] A, int[] B) {
        if(A == null || B == null)
            return null;
        int lenC = Math.min(A.length, B.length);
        int[] C = new int[lenC];
        int ptrA = 0, ptrB = 0, ptrC = 0;
        while (ptrA < A.length && ptrB < B.length) {
            if(A[ptrA] < B[ptrB]) {
                while(ptrA < A.length && A[ptrA] < B[ptrB]) ptrA++;
            } else {
                while(ptrB < B.length && B[ptrB] < A[ptrA]) ptrB++;
            }
            System.out.println("ptrA: " + ptrA + ", ptrB: " + ptrB);
            if(ptrA < A.length && ptrB < B.length && A[ptrA] == B[ptrB]) {
                System.out.println("ptrC: " + ptrC + ", value: " + A[ptrA]);
                C[ptrC++] = A[ptrA];
                ptrA++; ptrB++;

            }
        }
        return C;
    }
}
