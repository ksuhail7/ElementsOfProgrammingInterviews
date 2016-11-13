package com.suhailkandanur.eopi.ch12;

/**
 * Problem 12.1: Write a method that takes a sorted array A and a key <i>k</i>
 * and return the index of the first occurence of k in A. Return -1 if <i>k</i>
 * does not appear in A.
 * <p>
 * Created by suhail on 2016-11-13.
 */
public class ArraysP12_1 {
    public static int firstOccurence(int[] A, int k) {
        return firstOccurence(A, k, 0, A.length - 1);
    }

    private static int firstOccurence(int[] A, int k, int low, int high) {
        System.out.println("low: " + low +", high: " + high);
        if(A == null || low < 0 || high >= A.length)
            return -1;
        int found = -1;
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] == k) {
                found = mid;
            }
            if(A[mid] < k) {
                final int foundRight = firstOccurence(A, k, mid + 1, high);
                return foundRight;
            } else {
                final int foundLeft = firstOccurence(A, k, low, mid - 1);
                final int i = foundLeft == -1 ? found : foundLeft;
                System.out.println("Returning " + i);
                return i;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] A = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        System.out.println(firstOccurence(A, -14));
    }
}
