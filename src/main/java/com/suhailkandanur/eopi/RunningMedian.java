package com.suhailkandanur.eopi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by suhail on 2017-03-23.
 */
public class RunningMedian {
    public static void main(String[] args) {
        int arr[] = new int[]{1000,
                94455};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
//            System.out.println("adding element to min heap: " + arr[i]);
            while (minHeap.size() - maxHeap.size() > 1) {
//                System.out.println("Moving element from min heap to max heap: " + minHeap.peek());
                maxHeap.add(minHeap.poll());
            }

            if (minHeap.size() == maxHeap.size()) {
                System.out.println("median " + (minHeap.peek() + maxHeap.peek()) / 2.0);
            } else {
                System.out.println("median: " + (minHeap.peek() + 0.0));
            }
        }

//        while(minHeap.size() > 0) {
//            System.out.println(minHeap.poll());
//        }
    }
}
