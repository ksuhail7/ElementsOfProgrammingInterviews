package com.suhailkandanur.eopi.ch13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem 13.1: Write a function that takes as input a dictionary of English words, and returns
 * a  partition of the dictionary into subsets of words taht are all anagrams of each other.
 * <p>
 * Created by suhail on 2016-11-25.
 */
public class AnagramsP13_1 {
    private static final Logger logger = LoggerFactory.getLogger(AnagramsP13_1.class);

    public static void main(String[] args) {
        String dictWordsFile = "/usr/share/dict/words";
        List<Set<String>> sets = partitionAnagrams(dictWordsFile);
        sets.stream().filter(s -> s.size() > 1).forEach(set -> {
            String listAsStr = set.stream().collect(Collectors.joining(","));
            logger.info("{}", listAsStr);
        });
    }

    private static List<Set<String>> partitionAnagrams(String dictWordsFile) {
        int[] primes = firstNPrimes(26);
        Map<Integer, Set<String>> anagramMap = new HashMap<>();
        Path dictFile = Paths.get(dictWordsFile);
        if (Files.exists(dictFile)) {
            Charset charset = Charset.forName("US-ASCII");
            try (BufferedReader reader = Files.newBufferedReader(dictFile, charset)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    //System.out.println(line);
                    line = line.replaceAll("\\s*", "");
                    line = line.toLowerCase();
                    int product = 1;
                    for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);
                        if(!Character.isAlphabetic(c))
                            continue;
                        int index = Character.getNumericValue(c) - Character.getNumericValue('a');
                        product = product * primes[index];
                    }
                    Set<String> set = anagramMap.getOrDefault(product, new HashSet<>());
                    set.add(line);
                    anagramMap.put(product, set);
                    //System.out.println(line);
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
        }
        return new ArrayList<>(anagramMap.values());
    }

    public static int[] firstNPrimes(int n) {
        if (n < 0) {
            return null;
        }
        int[] primes = new int[n];
        int seq = 2;
        for (int i = 0; i < n; i++) {
            while (!isPrime(seq)) seq++;
            primes[i] = seq++;
        }
        return primes;
    }

    public static boolean isPrime(int n) {
        int noOfFactors = 1;
        int sqrtN = (int) Math.ceil(Math.sqrt(n));
        for (int i = 1; i <= sqrtN; i++) {
            if (n % i == 0) noOfFactors++;
            if (noOfFactors > 2)
                return false;
        }
        if (noOfFactors == 2) return true;
        return false;
    }
}
