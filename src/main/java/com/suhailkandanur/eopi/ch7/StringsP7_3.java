package com.suhailkandanur.eopi.ch7;

/**
 * Created by suhail on 2016-10-31.
 */
public class StringsP7_3 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal, Panama";
        String t = "Able was I, ere I saw Elba!";
        String w = "atta";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(t));
        System.out.println(isPalindrome(w));
    }
    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        boolean palindrome = true;
        while(start < end) {
            while(!Character.isLetterOrDigit(s.charAt(start)))  start++;
            while(!Character.isLetterOrDigit(s.charAt(end))) end--;
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                palindrome = false;
                break;
            }
            start++;
            end--;

        }
        return palindrome;
    }
}
