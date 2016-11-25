package com.suhailkandanur.eopi.ch13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Set;
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
        sets.stream().forEach(set -> {
            String listAsStr = set.stream().collect(Collectors.joining(","));
            logger.info("-----\n{}", listAsStr);
        });
        logger.info("done1");
    }

    private static List<Set<String>> partitionAnagrams(String dictWordsFile) {
        return Collections.emptyList(); //TODO: implementation pending
    }
}
