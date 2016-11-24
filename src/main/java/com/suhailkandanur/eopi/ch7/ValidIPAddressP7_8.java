package com.suhailkandanur.eopi.ch7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem 7.8: Write a function that determines where to add periods so taht the resulting file is valid.
 * There may be more than one valid IP address corresponding to a string, in whcih case you should print
 * all possibilities.
 *
 * Created by suhail on 2016-11-24.
 */
public class ValidIPAddressP7_8 {
    public List<String> validIPAddresses(String ip) {
        return validIPAddressHelper(ip, 4);
    }

    /**
     *
     * The string is broken down is parts based on the following rules
     * - the integer is between 1 and 255 (inclusive)
     * @param ip mangled IP address
     * @param noOfParts no. of parts to be formed
     * @return the list of IP addresses formed
     */
    private List<String> validIPAddressHelper(String ip, int noOfParts) {
        if(ip == null || ip.length() < 1)
            return Collections.emptyList();
        if(noOfParts <= 1) {
            return Arrays.asList(ip);
        }
        List<String> validIPsFormed = new ArrayList<>();
        for (int i = 1; i < 3 && i < ip.length(); i++) {
            String first = ip.substring(0, i);
            int valueOfFirst = Integer.valueOf(first);
            if(valueOfFirst > 0 && valueOfFirst < 256) {
                List<String> validIPs = validIPAddressHelper(ip.substring(i), noOfParts - 1);

            }
        }
        return null;
    }
    public static void main(String[] args) {
        String s ="abc";
        System.out.println(s.substring(0,1));
    }

}
