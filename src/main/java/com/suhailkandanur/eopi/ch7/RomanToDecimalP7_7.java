package com.suhailkandanur.eopi.ch7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 7.7: Write a function which takes as input a valid Roman number string s,
 * and return ths corresponding decimal integer.
 *
 * I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
 * Exceptions:
 * - I can immediately preceed V and X
 * - X can immediately preceed L and C
 * - C can immediately preceed D and M
 * Created by suhail on 2016-11-24.
 */
public class RomanToDecimalP7_7 {
    static final Map<Character, Integer>  romanSymbols = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(RomanToDecimalP7_7.class);

    static {
        romanSymbols.put('I', 1);
        romanSymbols.put('V', 5);
        romanSymbols.put('X', 10);
        romanSymbols.put('L', 50);
        romanSymbols.put('C', 100);
        romanSymbols.put('D', 500);
        romanSymbols.put('M', 1000);
    }
    public static int romanToDecimal(String roman) throws Exception {
        if(roman == null || roman.length() < 1)
            return 0;
        int value = 0;
        int previousValue = Integer.MAX_VALUE;
        char prev = Character.MIN_VALUE;
        for (int i = 0; i < roman.length(); i++) {
            char c = roman.charAt(i);
            if(!romanSymbols.containsKey(c))
                throw new Exception("invalid roman numeral " + roman + ", " + c + " is not valid symbol");
            int currentValue = romanSymbols.get(c);
            if((prev == 'I' && (c == 'V' || c == 'X'))
                    || (prev == 'X' && (c == 'L' || c == 'C'))
                    || (prev == 'C' && (c == 'D' || c == 'M'))) {
                currentValue = currentValue - romanSymbols.get(prev);
                value = value - romanSymbols.get(prev);
            } else {
                if (previousValue < currentValue) {
                    logger.error("errow while processing character {}, index {}", c, i);
                    throw new Exception("invalid roman numeral " + roman );
                }
            }
            prev = c;
            previousValue = currentValue;
            value = value + currentValue;
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        String roman= "CDLXIX";
        System.out.println(romanToDecimal(roman));
    }
}
