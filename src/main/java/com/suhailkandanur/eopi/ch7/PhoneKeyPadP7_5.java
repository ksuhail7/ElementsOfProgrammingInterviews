package com.suhailkandanur.eopi.ch7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by suhail on 2016-11-21.
 */
public class PhoneKeyPadP7_5 {

    static Map<Integer, char[]> keyPadMap = new HashMap<>();

    static {
        keyPadMap.put(0, new char[]{});
        keyPadMap.put(1, new char[]{});
        keyPadMap.put(2, new char[]{'a', 'b', 'c'});
        keyPadMap.put(3, new char[]{'d', 'e', 'f'});
        keyPadMap.put(4, new char[]{'g', 'h', 'i'});
        keyPadMap.put(5, new char[]{'j', 'k', 'l'});
        keyPadMap.put(6, new char[]{'m', 'n', 'o'});
        keyPadMap.put(7, new char[]{'p', 'q', 'r', 's'});
        keyPadMap.put(8, new char[]{'t', 'u', 'v'});
        keyPadMap.put(9, new char[]{'w', 'x', 'y', 'z'});

        //construct a valid list of words from dictionary
        String dictWordsFile = "/usr/share/dict/words";
        Path dictFile = Paths.get(dictWordsFile);
        if (Files.exists(dictFile)) {
            Charset charset = Charset.forName("US-ASCII");
            try (BufferedReader reader = Files.newBufferedReader(dictFile, charset)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    //System.out.println(line);
                    line = line.replaceAll("\\s*", "");
                    line = line.toLowerCase();

                }
            } catch (IOException ioe) {
                System.err.println("unable to construct list of words");
            }
        }
    }

    public static List<String> mnemonics(String numeric) {
        if (numeric == null || numeric.length() < 1)
            return Arrays.asList("");
        if (!Character.isDigit(numeric.charAt(0)))
            return Collections.emptyList();

        int first = Character.getNumericValue(numeric.charAt(0));
        List<String> stringList = mnemonics(numeric.substring(1));
        List<String> list = new ArrayList<>();
        for (char c : keyPadMap.get(first)) {
            list.addAll(stringList.stream().map(s -> c + s).collect(Collectors.toList()));
        }
        return list;
    }

    public static void main(String[] args) {
        mnemonics("283743").forEach(System.out::println);
    }
}
