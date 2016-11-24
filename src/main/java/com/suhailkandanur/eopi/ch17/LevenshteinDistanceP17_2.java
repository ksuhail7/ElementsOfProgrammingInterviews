package com.suhailkandanur.eopi.ch17;

import static jdk.nashorn.internal.objects.NativeMath.min;

/**
 * Created by suhail on 2016-11-14.
 */
public class LevenshteinDistanceP17_2 {
    public static int levenshteinDistance(String s, String t) {
        if(s == null || s.length() < 1) return t == null ? 0 : t.length();
        if(t == null || t.length() < 1) return s == null ? 0 : s.length();

        int[] v1 = new int[t.length()+1];
        int[] v2 = new int[t.length()+1];

        for (int i = 0; i <= t.length(); i++) {
            v1[i] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            printArray(v1);
            v2[0] = i+1;
            for (int j = 0; j < t.length(); j++) {
                int cost = t.charAt(j) == s.charAt(i) ? 0 : 1;
                v2[j+1] = Math.min(Math.min(v1[j] + cost, v1[j+1] + 1) , v2[j] + 1);
            }
            for (int j = 0; j <= t.length(); j++) {
                v1[j] = v2[j];
            }
        }
        printArray(v1);
        return v2[t.length()];
    }

    private static void printArray(int[] array) {
        if(array == null)
            return;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s1 = "string";
        String s2 = "sting";
        System.out.println(levenshteinDistance(s2, s1));
    }
}
