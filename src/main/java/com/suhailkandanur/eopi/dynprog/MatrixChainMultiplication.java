package com.suhailkandanur.eopi.dynprog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suhail on 2017-04-15.
 */
public class MatrixChainMultiplication {

    public static int cost(int[][] dimensions, int i, int k, int j) {
        int row_i = dimensions[i][0];
        int col_k = dimensions[k][1];
        int col_j = dimensions[j][1];


        return row_i * col_k * col_j;
    }

    public static int matrixChainMultIterative(int[][] dimensions, int n) {
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == j)
                    m[i][i] = 0;
                else
                    m[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                for (int k = i; k < j; k++) {
                    int val = m[i][k] + m[k + 1][j] + cost(dimensions, i, k, j);
                    if (m[i][j] > val) m[i][j] = val;
                }
            }
        }
        return m[0][n - 1];
    }

    public static int matrixChainMult(int[][] dimensions, int n) {
        return matrixChainMult(dimensions, 0, n - 1, new HashMap<>());
    }

    public static int matrixChainMult(int[][] dimensions, int i, int j, Map<String, Integer> memo) {
        if (i == j) return 0;
        if (memo.containsKey(i + "-" + j)) {
            return memo.get(i + "-" + j);
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int val = matrixChainMult(dimensions, i, k, memo) + matrixChainMult(dimensions, k + 1, j, memo) + cost(dimensions, i, k, j);
            if (min > val) min = val;
        }
        memo.put(i + "-" + j, min);
        return min;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] dimensions = new int[][]{
                {10, 100},
                {100, 5},
                {5, 50}
        };

        System.out.println(matrixChainMultIterative(dimensions, n));


    }
}
