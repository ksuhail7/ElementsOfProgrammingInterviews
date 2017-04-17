package com.suhailkandanur.eopi.dynprog;

/**
 * Created by suhail on 2017-04-16.
 */
public class LevensteinEditDistance {

    public static int minEditDistance(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int[][] ed = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            ed[i][0] = 0;
        }

        for (int i = 0; i < s2.length() + 1; i++) {
            ed[0][i] = 0;
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                int min = Math.min(ed[i - 1][j], Math.min(ed[i - 1][j - 1], ed[i][j - 1]));
                ed[i][j] = (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1) + min;
            }
        }
        return ed[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "string", s2 = "str";
        System.out.println(minEditDistance(s1, s2));
    }
}
