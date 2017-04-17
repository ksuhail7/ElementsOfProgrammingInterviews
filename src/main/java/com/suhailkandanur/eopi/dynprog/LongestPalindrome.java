package com.suhailkandanur.eopi.dynprog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suhail on 2017-04-16.
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        if (s == null || s.length() < 1) return 0;
        if (s.length() == 1) return 1;
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return 2 + longestPalindrome(s.substring(1, s.length() - 1));
        } else {
            return Math.max(longestPalindrome(s.substring(0, s.length() - 1)), longestPalindrome(s.substring(1, s.length())));
        }
    }

    public static int longestPalindromeMemoization(String s) {
        if (s == null || s.length() < 1) return 0;
        Map<String, String> seq = new HashMap<>();
        int max = longestPalindromeMemoization(s, 0, s.length() - 1, new HashMap<>(), seq);
        System.out.println(seq.get("0-" + (s.length() - 1)));
        return max;
    }

    public static int longestPalindromeMemoization(String s, int i, int j, Map<String, Integer> memo, Map<String, String> seq) {
        String key = i + "-" + j;
        if (i > j || s == null) {
            seq.put(key, "");
            return 0;
        }
        if (i == j) {
            seq.put(key, s.substring(i, i + 1));
            return 1;
        }
        if (memo.containsKey(key)) return memo.get(key);
        int max = 0;
        if (s.charAt(i) == s.charAt(j)) {
            max = 2 + longestPalindromeMemoization(s, i + 1, j - 1, memo, seq);
            seq.put(key, s.charAt(i) + seq.get((i + 1 + "-" + (j - 1))) + s.charAt(j));
        } else {
            int m1 = longestPalindromeMemoization(s, i + 1, j, memo, seq);
            int m2 = longestPalindromeMemoization(s, i, j - 1, memo, seq);
            if (m1 > m2) {
                max = m1;
                seq.put(key, seq.get((i + 1) + "-" + j));
            } else {
                max = m2;
                seq.put(key, seq.get(i + "-" + (j - 1)));
            }
        }
        memo.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        String s = "character";
        System.out.println(longestPalindromeMemoization(s));
    }
}
