package com.suhailkandanur.eopi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by suhail on 2017-03-31.
 */
public class ComplexArthimetic {
    public static String complexNumberMultiply(String a, String b) {
        Complex num1 = Complex.parseComplex(a);
        Complex num2 = Complex.parseComplex(b);
        return num1.toString();
    }

    public static void main(String[] args) {
        String s = "i";
        Complex num1 = Complex.parseComplex(s);
        System.out.println(num1.toString());
    }

    private static class Complex {
        private static final Pattern PARSE_REGEX_REAL = Pattern.compile("^([+-]?\\d*).*");
        private static final Pattern PARSE_REGEX_IMAG = Pattern.compile(".*?([+-]?\\d*)i$");
        private final int real;
        private final int imag;

        public Complex(int real, int imag) {
            this.real = real;
            this.imag = imag;
        }

        public static Complex parseComplex(String s) {
            int real = 0, imag = 0;

            Matcher m = PARSE_REGEX_REAL.matcher(s);
            if (m.matches()) {
                try {
                    String realStr = m.group(1);
                    real = Integer.parseInt(m.group(1));
                } catch (NumberFormatException nfe) {
                }
            }
            m = PARSE_REGEX_IMAG.matcher(s);
            if (m.matches()) {
                try {
                    String imagStr = m.group(1);
                    if (Pattern.matches("[+-]?", imagStr)) imagStr += "1";
                    imag = Integer.parseInt(imagStr);
                } catch (NumberFormatException nfe) {
                }
            }


            return new Complex(real, imag);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (real != 0) {
                sb.append(real);
            }
            if (imag != 0) {
                sb.append(imag < 0 ? "-" : "+");
                sb.append(Math.abs(imag) == 1 ? "" : Math.abs(imag));
                sb.append("i");
            }
            return sb.toString();
        }

        public Complex multiply(final Complex that) {
            if (that == null)
                return null;

            int productReal = (this.real * that.real) - (this.imag * that.imag);
            int productImag = (this.real * that.imag) + (this.imag * that.real);
            return new Complex(productReal, productImag);
        }
    }
}
