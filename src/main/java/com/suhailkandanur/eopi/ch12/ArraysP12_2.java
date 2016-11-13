package com.suhailkandanur.eopi.ch12;

import static com.suhailkandanur.eopi.ch12.ArraysP12_1.firstOccurence;

/**
 * Design an efficient algorithm that takes a sorted array A and a key <i>k</i>
 * and finds the index of the first occurrence an element greater than k;
 * return -1 if every element is less than or equals to k.
 * Created by suhail on 2016-11-13.
 */
public class ArraysP12_2 {

    public static int firstOccurenceGreaterThan(int[] A, int k) {
        if(A == null)
            return -1;
        return firstOccurenceGreaterThan(A, k, 0, A.length - 1);
    }

    private static int firstOccurenceGreaterThan(int[] A, int k, int low, int high) {
        if(A == null || low < 0 || high > A.length - 1)
            return -1;

        int found = -1;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(A[mid] == k) {
                found = mid;
            }
            if(A[mid] > k) {
                found = mid;
                int foundLeft = firstOccurenceGreaterThan(A, k, low, mid - 1);
                return foundLeft == -1 ? found : foundLeft;
            } else {
                return firstOccurenceGreaterThan(A, k, mid + 1, high);
            }

        }
        return found;


    }
    public static void main(String[] args) {
        int[] A = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        System.out.println(firstOccurenceGreaterThan(A, 101));
    }


}
