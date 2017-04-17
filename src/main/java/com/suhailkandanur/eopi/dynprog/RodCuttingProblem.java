package com.suhailkandanur.eopi.dynprog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suhail on 2017-04-15.
 */
public class RodCuttingProblem {
    public static int maxProfit(int[] price, int size) {
        if (size == 1) return price[size - 1];
        int max = price[size - 1];
        for (int i = 1; i < size; i++) {
            int val = price[size - i - 1] + maxProfit(price, i);
            if (max < val) max = val;
        }
        return max;
    }

    public static int maxProfitMemoized(int[] price, int size) {
        return maxProfitMemoizedHelper(price, size, new HashMap<>());
    }

    public static int maxProfitMemoizedHelper(int[] price, int size, Map<Integer, Integer> memo) {
        if (memo.containsKey(size))
            return memo.get(size);
        int max = price[size - 1];
        for (int i = 1; i < size; i++) {
            int val = price[size - i - 1] + maxProfit(price, i);
            if (max < val) max = val;
        }
        memo.put(size, max);
        return max;
    }

    public static int maxProfitIterative(int[] prices, int size, int[] cuts) {
        int[] r = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            r[i] = 0;
            cuts[i] = i;
        }
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                int val = prices[i - j - 1] + r[j];
                if (r[i] < val) {
                    r[i] = val;
                    cuts[i] = i - j;
                }
            }
        }
        return r[size];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] cuts = new int[prices.length + 1];
        int n = 7;
        System.out.println(maxProfitIterative(prices, n, cuts));
        int seg = n;
        while (seg > 0) {
            System.out.print(cuts[seg] + " ");
            seg = seg - cuts[seg];
        }
        System.out.println();
    }
}
