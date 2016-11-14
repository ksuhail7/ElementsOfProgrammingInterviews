package com.suhailkandanur.eopi.ch14;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 14.3: Given a string s, print in alphabetical order each character that appears in s,
 * and the number of times it appears.
 * For eg, if s = "bcdacebe", output "(a,1), (b,2), (c, 2), (d,1), (e,2)".
 * Created by suhail on 2016-11-13.
 */
public class CharFrequenciesP14_3 {
    public static void printFrequencies(String s) {
        int[] array = new int[26];
        for (int i = 0; s != null && i < s.length(); i++) {
            char c = s.charAt(i);
            int index = Character.toLowerCase(c) - 'a';
            array[index]++;
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0)
                System.out.println((char) ('a' + i) + "," + array[i]);
        }

    }

    public static void main(String[] args) {
        String s = "bcdacebe";
        printFrequencies(s);
    }
}
