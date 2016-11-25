package com.suhailkandanur.eopi.ch7;

/**
 * Problem 7.6: Write a function that takes as input an integer n,
 * and returns the n-th integer in the look-and-say sequence.
 * Return the result as string.
 * Created by suhail on 2016-11-24.
 */
public class LookAndSayP7_6 {
    private static String lookAndSaySeq(int n) {
        if(n <= 1)
            return "1";
        String prev = lookAndSaySeq(n - 1);
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i < prev.length()) {
            char c = prev.charAt(i);
            int count = 1;
            while(++i< prev.length() && prev.charAt(i) == c) count++;
            builder.append(count).append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(lookAndSaySeq(6));
    }
}