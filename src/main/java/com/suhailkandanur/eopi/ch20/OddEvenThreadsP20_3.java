package com.suhailkandanur.eopi.ch20;

/**
 * Problem 20.3: Thread T1 prints odd numbers from 1 to 100; Thread T2 prints even numbers from 1 to 100.
 * Write Java code in which the two threads, running concurrently, print the numbers from 1 to 100 in order.
 * <p>
 * Created by suhail on 2016-11-26.
 */
public class OddEvenThreadsP20_3 {
    private volatile boolean isOdd;

    Runnable oddPrinter = () -> {
        int count = 1;
        while (count < 100) {
            while (isOdd == false) ;
            System.out.println(count);
            count+=2;
            isOdd = false;
        }
    };

    Runnable evenPrinter = () -> {
        int count = 2;
        while (count <= 100) {
            while (isOdd == true) ;
            System.out.println(count);
            count+=2;
            isOdd = true;
        }
    };

    public void printNumbers() {
        isOdd = true;
        Thread t1 = new Thread(oddPrinter);
        Thread t2 = new Thread(evenPrinter);
        t2.start();
        t1.start();
    }

    public static void main(String[] args) {
        new OddEvenThreadsP20_3().printNumbers();
    }
}
