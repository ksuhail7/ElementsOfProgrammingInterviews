package com.suhailkandanur.eopi.ch6;
import java.lang.*;
public class DutchNationalFlagP6_1 {
	public static void rearrange(int[] A, int k) {
		if(A == null || k >= A.length)
			return;
		int pivot = A[k];
		int smaller = 0,equals = 0, larger = A.length - 1;

		while(equals <= larger) {
			if(A[equals] < pivot) {
				int tmp = A[smaller];
				A[smaller++] = A[equals];
				A[equals++] = tmp;
			} else if(A[equals] == pivot) {
				equals++;
			} else {
				int tmp = A[larger];
				A[larger--] = A[equals];
				A[equals] = tmp;
			}
		}
	}

	public static void printArray(int[] array) {
		if(array == null) return;
		for(int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = new int[] {2, 7, 1, 0, 3, 4, 9, 5};
		rearrange(array, 4);
		printArray(array);
	}
}
