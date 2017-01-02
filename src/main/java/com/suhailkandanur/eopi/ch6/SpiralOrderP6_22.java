package com.suhailkandanur.eopi.ch6;

/**
 * Created by suhail on 2016-12-28.
 */
public class SpiralOrderP6_22 {
    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }

    public static void spiralOrder(int[][] array) {
        if (array == null)
            return;
        int noOfRows = array.length;
        int noOfCols = array[0].length;
        int MxN = noOfRows * noOfCols;
        int[] rows_visited = new int[array.length];
        int[] cols_visited = new int[array[0].length];
        int i = 0, j = 0;
        int count = 0;
        Direction direction = Direction.RIGHT;
        while (count < MxN) {
            count++;
            int value = array[i][j];
            System.out.print(value + " ");
            switch (direction) {
                case RIGHT:
                    j++;
                    break;
                case LEFT:
                    j--;
                    break;
                case UP:
                    i--;
                    break;
                case DOWN:
                    i++;
                    break;
            }
            Direction newDirection = direction;
            if (j >= noOfCols || (j >= 0 && cols_visited[j] == 1 && direction == Direction.RIGHT)) {
                direction = Direction.DOWN;
                rows_visited[i] = 1;
                j--;
                i++;
            } else if (j < 0 || (j < noOfCols && cols_visited[j] == 1 && direction == Direction.LEFT)) {
                direction = Direction.UP;
                rows_visited[i] = 1;
                j++;
                i--;
            }

            if (i >= noOfRows || (i >= 0 && rows_visited[i] == 1 && direction == Direction.DOWN)) {
                direction = Direction.LEFT;
                cols_visited[j] = 1;
                i--;
                j--;
            } else if (i < 0 || (i < noOfRows && rows_visited[i] == 1 && direction == Direction.UP)) {
                direction = Direction.RIGHT;
                cols_visited[j] = 1;
                i++;
                j++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4, 5}, {4, 5, 6, 7, 8}, {7, 8, 9, 10, 11}, {12, 13, 14, 15, 16}};
        print2DArray(array);
        spiralOrder(array);
    }
}
