package com.suhailkandanur.eopi.ch17;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suhail on 2017-03-25.
 */
public class KnapsackP17_7 {

    public static int knapsack(int[] prices, int[] weights, int target) {
        return knapsack(prices, weights, target, 0, new HashMap<>());
    }

    public static int knapsack(int[] prices, int[] weights, int target, int index, Map<String, Integer> memo) {
        if (target <= 0 || prices == null || weights == null || prices.length != weights.length || index < 0 || index >= prices.length)
            return 0;
        String key = target + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int max = 0;
        for (int i = 0; i < 2; ++i) {
            int price = i * prices[index];
            int weight = i * weights[index];
            if (weight > target)
                continue;
            int remaining = target - weight;
            max = Math.max(max, knapsack(prices, weights, remaining, index + 1, memo) + price);
        }

        memo.put(key, max);
        return max;
    }

    public static int pricesOf(int[] prices, Integer[] items) {
        if (prices == null || prices.length < 1 || items == null) {
            System.err.println("prices are null");
        }
        int totalValue = 0;
        for (int i = 0; items != null && i < items.length; ++i) {
            int itemIndex = items[i];
            totalValue += prices[itemIndex];
        }
        return totalValue;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{65, 35, 245, 195, 65, 150, 275, 155, 120, 320, 75, 40, 200, 100, 220, 99};
        int[] weights = new int[]{20, 8, 60, 55, 40, 70, 85, 25, 30, 65, 75, 10, 95, 50, 40, 10};

        int maxValue = knapsack(prices, weights, 130);
        System.out.println("price: " + maxValue);


    }
}
