package com.suhailkandanur.eopi.ch7;

/**
 * Problem 7.10: Implement run-length encoding and decoding functions.
 * Assume the string to be encoded consists of letters of the alphabet, with no digits,
 * and the string to be decoded is a valid encoding.
 * <p>
 * Created by suhail on 2016-11-25.
 */
public class RunLenthEncDecP7_10 {
    public static String encodeRLC(String plain) {
        if(plain == null || plain.length() < 1)
            return plain;
        int count = 0;
        char prev = plain.charAt(0);
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < plain.length(); i++) {
            char c = plain.charAt(i);
            if(c == prev)
                count++;
            else {
                builder.append(count).append(prev);
                count = 1;
            }
            prev = c;
        }
        builder.append(count).append(prev);
        return builder.toString();

    }

    public static String decodeRLC(String encoded) {
        if (encoded == null || encoded.length() < 1) {
            return encoded;
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < encoded.length()) {
            String num = "";
            while(Character.isDigit(encoded.charAt(i))) num = num + encoded.charAt(i++);
            char c = encoded.charAt(i);
            for (int j = 0; j < Integer.valueOf(num); j++) {
                builder.append(c);
            }
            i++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String plain = "aaaabcccaa";
        System.out.println(encodeRLC(plain));
        System.out.println(decodeRLC(encodeRLC(plain)));
        assert (plain.equals(decodeRLC(encodeRLC(plain))));
    }
}
