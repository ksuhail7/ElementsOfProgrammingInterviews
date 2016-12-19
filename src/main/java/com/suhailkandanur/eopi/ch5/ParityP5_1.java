package com.suhailkandanur.eopi.ch5;

/**
 * Created by suhail on 2016-12-18.
 */
public class ParityP5_1 {
    public static int parity(int number) {
        int last = 0b0;
        while(number > 0) {
            short last_bit = (short) (number & 0b1);
            last = last ^ last_bit;
            number = number >> 1;
        }
        return last;
    }

    public static void main(String[] args) {
        int num = 0b110;
        System.out.println(parity(num));
    }
}
