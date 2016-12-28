package com.suhailkandanur.eopi.ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by suhail on 2016-12-22.
 */
public class ScoreCombinationsP17_1 {
    private static List<List<Combination>> combinations(List<Integer> denom, int index, int total) {
        if (denom == null || denom.size() < index + 1 || total <= 0) {
            return Collections.emptyList();
        }
        List<List<Combination>> list = new ArrayList<>();
        int firstDenom = denom.get(index);
        int n = total / firstDenom;
        for (int i = 0; i <= n; i++) {
            int remaining = total - (i * firstDenom);
            Combination current = new Combination(firstDenom, i);
            if (remaining != 0) {
                List<List<Combination>> combinations = combinations(denom, index + 1, remaining);
                if (combinations != null && combinations.size() > 0) {

                    for (List<Combination> combinationList : combinations) {
                        List<Combination> newList = new ArrayList<>();
                        newList.add(current);
                        newList.addAll(combinationList);
                        list.add(newList);
                    }
                }
            } else {
                list.add(new ArrayList(Arrays.asList(current)));
            }

        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> denominations = new ArrayList<>(Arrays.asList(2, 5, 10));
        int total = 17;
        List<List<Combination>> combinations = combinations(denominations, 0, total);
        if (combinations != null) {
            for (List<Combination> combinationList : combinations) {
                for (Combination combination : combinationList) {
                    if (combination.getCount() != 0) {
                        System.out.print("[" + combination.getDenom() + ", " + combination.getCount() + "]");
                    }
                }
                System.out.println();
            }

        }
        System.out.println("done");
    }

    private static final class Combination {
        final int denom;
        final int count;

        public Combination(int denom, int count) {
            this.denom = denom;
            this.count = count;
        }

        public int getDenom() {
            return denom;
        }

        public int getCount() {
            return count;
        }
    }
}


