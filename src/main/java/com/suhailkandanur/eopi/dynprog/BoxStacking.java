package com.suhailkandanur.eopi.dynprog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by suhail on 2017-04-16.
 */
public class BoxStacking {

    public static int maxHeightIterative(List<Box> boxes) {
        if (boxes == null || boxes.size() < 1) {
            return 0;
        }
        int n = boxes.size();
        int[][] mh = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            mh[i][0] = boxes.get(i - 1).getHeight();
        }
        for (int i = 0; i < n + 1; i++) {
            mh[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (boxes.get(j - 1).canStackOn(boxes.get(i - 1))) {
                    mh[i][j] = Math.max(mh[i][j - 1], mh[i - 1][j]) + boxes.get(j - 1).getHeight();
                } else {
                    mh[i][j] = Math.max(mh[i][j - 1], mh[i - 1][j]);
                }
            }
        }
        printArray(mh);
        return mh[n][n];
    }

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        //{4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32}
        int[] h = new int[]{1, 4, 4, 10};
        int[] w = new int[]{2, 6, 5, 12};
        int[] d = new int[]{3, 7, 6, 32};

        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxes.add(new Box(h[i], w[i], d[i]));
            boxes.add(new Box(w[i], h[i], d[i]));
            boxes.add(new Box(d[i], w[i], h[i]));
        }

        boxes.sort(Comparator.naturalOrder());
//        for(int i = 0; i < boxes.size(); i++) {
//            System.out.println(boxes.get(i));
//        }
//        System.exit(0);
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < boxes.size(); i++) {
            Box base = boxes.get(i);
            int height = base.getHeight();
            for (int j = i + 1; j < boxes.size(); j++) {
                if (boxes.get(j).canStackOn(base)) {
                    base = boxes.get(j);
                    height += base.getHeight();
                }
            }
            if (maxHeight < height)
                maxHeight = height;
        }

        System.out.println("Max height: " + maxHeightIterative(boxes));
//        System.out.println("Max height: " + maxHeight);
    }

    public static class Box implements Comparable<Box> {
        private final int h, d, w;

        public Box(int h, int w, int d) {
            this.h = h;
            this.w = w;
            this.d = d;
        }

        public int baseArea() {
            return this.w * this.d;
        }

        public boolean canStackOn(Box b) {
            return (b.w > this.w && b.d > this.d);
        }

        @Override
        public int compareTo(Box o) {
            return o.baseArea() - this.baseArea();
        }

        @Override
        public String toString() {
            return String.format("(H:%s, W:%s, D:%s)", h, w, d);
        }

        public int getHeight() {
            return this.h;
        }
    }
}
