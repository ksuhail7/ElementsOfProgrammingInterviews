package com.suhailkandanur.eopi.ch7;

/**
 * Created by suhail on 2016-10-31.
 */
public class StringsP7_4 {
    public static void main(String[] args) {
        String s = "Alice likes Bob";
        String t = "ta to";
        System.out.println(reverseWords(s.toCharArray()));
        System.out.println(reverseWords(t.toCharArray()));
    }
    public static String reverseWords(char[] s) {
        int start = 0, end = s.length - 1;
        while(start < end) {
            char c1 = s[start];
            s[start] = s[end];
            s[end] = c1;
            start++;
            end--;
        }
        //now reverse each word
        start = 0;
        while(start < s.length) {
            int p = start;
            while(p < s.length && s[p] != ' ') p++;
            end = p - 1;
            while(start < end) {
                char c1 = s[start];
                s[start] = s[end];
                s[end] = c1;
                start++;
                end--;
            }
            start = p + 1;
        }
        return new String(s);
    }
}
