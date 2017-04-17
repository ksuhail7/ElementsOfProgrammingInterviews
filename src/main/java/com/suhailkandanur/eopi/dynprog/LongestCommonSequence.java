package com.suhailkandanur.eopi.dynprog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suhail on 2017-04-15.
 */
public class LongestCommonSequence {
    public static int LCS(String X, String Y) {
        if (X == null || Y == null || "".equals(X) || "".equals(Y)) return 0;

        if (X.charAt(0) == Y.charAt(0))
            return 1 + LCS(X.substring(1), Y.substring(1));
        else
            return Math.max(LCS(X, Y.substring(1)), LCS(X.substring(1), Y));
    }


    public static int LCSMemoization(String X, String Y) {
        Map<String, String> sequence = new HashMap<>();
        int max = LCSMemoization(X, Y, 0, 0, new HashMap<>(), sequence);
        System.out.println(sequence.get("0-0"));
        return max;

    }

    public static int LCSMemoization(String X, String Y, int i, int j, Map<String, Integer> memo, Map<String, String> sequence) {
        String key = i + "-" + j;
        if (X == null || Y == null || i >= X.length() || j >= Y.length()) {
            sequence.put(key, "");
            return 0;
        }
        if (memo.containsKey(key)) return memo.get(key);
        int max = 0;
        String subStrX = X.substring(i);
        String subStrY = Y.substring(j);
        if (subStrX.charAt(0) == subStrY.charAt(0)) {
            max = 1 + LCSMemoization(X, Y, i + 1, j + 1, memo, sequence);
            sequence.put(key, new String(subStrX.charAt(0) + sequence.get((i + 1) + "-" + (j + 1))));
        } else {
            int m1 = LCSMemoization(X, Y, i + 1, j, memo, sequence);
            int m2 = LCSMemoization(X, Y, i, j + 1, memo, sequence);
            if (m1 > m2) {
                max = m1;
                String key1 = (i + 1) + "-" + j;
                sequence.put(key, sequence.get(key1));
            } else {
                max = m2;
                String key2 = (i) + "-" + (j + 1);
                sequence.put(key, sequence.get(key2));
            }
        }
        memo.put(key, max);
        return max;
    }

    public static int LCSIterative(String X, String Y) {
        if (X == null || Y == null || X.length() < 1 || Y.length() < 1) return 0;
        int lenX = X.length();
        int lenY = Y.length();
        int[][] lcs = new int[lenX + 1][lenY + 1];
        char[][] path = new char[lenX + 1][lenY + 1];

        for (int i = 0; i <= lenX; i++)
            lcs[i][0] = 0;
        for (int i = 0; i <= lenY; i++)
            lcs[0][i] = 0;

        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                    path[i][j] = '\\';
                } else {
                    int m1 = lcs[i - 1][j];
                    int m2 = lcs[i][j - 1];
                    if (m1 > m2) {
                        path[i][j] = '^';
                        lcs[i][j] = m1;
                    } else if (m1 < m2) {
                        path[i][j] = '<';
                        lcs[i][j] = m2;
                    } else {
                        // m1 == m2
                        path[i][j] = ' ';
                        lcs[i][j] = m1; // = m2
                    }
                }
            }
        }

        return lcs[lenX][lenY];
    }

    public static void main(String[] args) {
        String X = "ABABCABD";
        String Y = "ABWCFD";

        System.out.println(LCSIterative(X, Y));
    }
}
