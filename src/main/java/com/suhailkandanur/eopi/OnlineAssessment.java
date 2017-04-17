package com.suhailkandanur.eopi;

import java.util.Arrays;

/**
 * Created by suhail on 2017-03-26.
 */
public class OnlineAssessment {

    public static int getDifference(int[] S, int P) {
        if (P < 1 || S == null || S.length < 2) return 0;
        int[] sorted = Arrays.copyOf(S, S.length);
        Arrays.sort(sorted);
        return getDifferenceHelper(sorted, 0, P);
    }

    public static int getDifferenceHelper(int[] S, int start, int P) {
        if (P < 1 || S == null || start < 0 || start >= S.length - 2) return 0;
        int minDifference = Integer.MAX_VALUE;
        int d = Math.abs(S[start] - S[start + 1]);
        System.out.println(String.format("start: %d, diff: %d, P: %d", start, d, P));
        for (int i = start + 2; i < S.length - 1; i++) {
            int diff = getDifferenceHelper(S, i, P - 1);
            if (diff < minDifference) minDifference = diff;
            System.out.println(String.format("subseq starting %d has min diff: %d", i, diff));
        }
        return minDifference + d;
    }

    public static void main(String[] args) {
        int[] socks = new int[]{42, 37, 84, 36, 41, 42};
        System.out.println(getDifference(socks, 3));
    }
}
