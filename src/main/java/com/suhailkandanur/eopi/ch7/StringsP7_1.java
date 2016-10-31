package com.suhailkandanur.eopi.ch7;

/**
 * Created by suhail on 2016-10-30.
 */
public class StringsP7_1 {

    public static int parseInt(String intAsStr) throws Exception {
        boolean isNeg = false;
        int startIndex = 0;
        int intValue = 0;
        if(intAsStr.startsWith("-")) {
            isNeg = true;
            startIndex = 1;
        }
        for(int i = startIndex; i < intAsStr.length(); ++i) {
            char c = intAsStr.charAt(i);
            int charValue = c - '0';
            if(charValue < 0 || charValue > 9) {
                throw new Exception("invalid format, cannot parse string " + intAsStr + " to integer");
            }
            intValue = (intValue * 10) + charValue;

        }
        return isNeg ? -intValue : intValue;
    }

    public static String intToStr(int intToConvert) {
        StringBuilder builder = new StringBuilder();
        if(intToConvert == 0) return "0";
        boolean isNeg = intToConvert < 0;
        if(isNeg) {
            intToConvert = -intToConvert;
        }
        while(intToConvert > 0) {
            int n = intToConvert % 10;
            intToConvert = intToConvert / 10;
            builder.append(n);
        }
        if(isNeg) builder.append("-");
        return builder.reverse().toString();
    }
}
