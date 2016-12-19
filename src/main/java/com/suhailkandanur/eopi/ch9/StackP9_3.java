package com.suhailkandanur.eopi.ch9;

import java.util.Stack;

/**
 * Created by suhail on 2016-12-18.
 */
public class StackP9_3 {
    public static void main(String[] args) {
        String s = "()[]{()()}[[";
        System.out.println("s: " + isPbbMatched(s));
    }

    public static boolean isPbbMatched(String s) {
        if(s == null || "".equals(s))
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.empty() && ((c == ')' && stack.peek() == '(') || (c=='}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[')))
                stack.pop();
            else
                stack.push(c);
        }
        return stack.empty() ? true: false;
    }
}
