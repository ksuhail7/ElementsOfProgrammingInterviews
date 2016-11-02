package com.suhailkandanur.eopi.ch7;

/**
 * Created by suhail on 2016-10-31.
 */
public class StringsP7_2 {
    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'a'};
        System.out.println(replaceStr(s));
    }
    
    public static char[] replaceStr(char[] s) {
        int writeInd = 0, countA = 0;
        for(char c : s) {
            if(c != 'b') {
                s[writeInd++] = c;
            }
            if(c == 'a') countA++;
        }

        return s;
    }
}
