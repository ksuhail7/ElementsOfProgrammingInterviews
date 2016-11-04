package com.suhailkandanur.eopi.util;

import java.util.Random;

import static org.apache.coyote.http11.Constants.a;

/**
 * Created by suhail on 2016-11-03.
 */
public class RandomGen {
    public static int[] generateRandom(int size, int max) {
        return generateRandom(size, 0, max);
    }

    public static int[] generateRandom(int size, int min, int max) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int rand = random.nextInt(max - min + 1) + min;
            arr[i] = rand;
        }
        return arr;
    }

    public static int[] generateRandom(int size) {
        return generateRandom(size, 100);
    }
}
