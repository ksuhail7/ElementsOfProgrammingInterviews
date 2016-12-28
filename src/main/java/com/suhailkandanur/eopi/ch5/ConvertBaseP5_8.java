package com.suhailkandanur.eopi.ch5;

/**
 * Created by suhail on 2016-12-28.
 */
public class ConvertBaseP5_8 {
    public static String convertBase(String s, int base1, int base2) throws Exception {
        return convertDecimalToBase(convertToDecimal(s, base1), base2);
    }

    public static int convertToDecimal(String s, int base) throws Exception {
        if (base < 2 || base > 16) {
            throw new Exception("invalid base " + base);
        }
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = charToInt(s.charAt(s.length() - i - 1));
            int multiplier = (int) Math.pow(base, i);
            value = value + (val * multiplier);
        }
        return value;
    }

    public static String convertDecimalToBase(int value, int base) throws Exception {
        if (base < 2 || base > 16) {
            throw new Exception("invalid base " + base);
        }
        int copyOfValue = value;
        StringBuffer buffer = new StringBuffer();
        while (copyOfValue > 0) {
            int remainder = copyOfValue % base;
            if (remainder > 9)
                buffer.append('a' + remainder - 10);
            else
                buffer.append(remainder);
            copyOfValue = copyOfValue / base;
        }
        return buffer.reverse().toString();
    }

    public static int charToInt(char s) throws NumberFormatException {
        if (s >= '0' && s <= '9') {
            return s - '0';
        } else if (s >= 'a' && s <= 'f') {
            return s - 'a' + 10;
        } else if (s >= 'A' && s <= 'F') {
            return s - 'A' + 10;
        } else {
            throw new NumberFormatException("invalid character " + s);
        }
    }

    public static void main(String[] args) throws Exception {
        String s = "a";
        System.out.println(convertBase(s, 16, 8));

    }

    private static enum ExtendedDigits {
        A(10), a(10), B(11), b(11), C(12), c(12), D(13), d(13), E(14), e(14), F(15), f(15);

        private int value;

        private ExtendedDigits(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}
