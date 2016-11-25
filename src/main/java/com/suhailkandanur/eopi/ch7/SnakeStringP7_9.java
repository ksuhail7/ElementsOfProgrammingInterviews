package com.suhailkandanur.eopi.ch7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Write a function which takes as input a string s and returns the snakestring of s.
 * Created by suhail on 2016-11-25.
 */
public class SnakeStringP7_9 {
    private static final Logger logger = LoggerFactory.getLogger(SnakeStringP7_9.class);

    public static String snakeString(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        StringBuilder snakeString = new StringBuilder("");
        for (int i = 1 ; i < s.length(); i+=4) {
            snakeString.append(s.charAt(i));
        }
        for (int i = 0;  i < s.length(); i+=2) {
            snakeString.append(s.charAt(i));
        }
        for (int i = 3; i < s.length(); i+=4) {
            snakeString.append(s.charAt(i));
        }
        return snakeString.toString();
    }
    public static void main(String[] args) {
        String s = "Hello World!";
        System.out.println(snakeString(s));
    }
}
