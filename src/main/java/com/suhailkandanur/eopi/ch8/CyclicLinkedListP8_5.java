package com.suhailkandanur.eopi.ch8;

import com.suhailkandanur.eopi.util.LinkedList;
import com.suhailkandanur.eopi.util.Node;
import com.suhailkandanur.eopi.util.RandomGen;

/**
 * Created by suhail on 2016-12-29.
 */
public class CyclicLinkedListP8_5 {
    public static void main(String[] args) {
        Node cyclicList = LinkedList.createCyclicList(RandomGen.generateRandom(10, 0, 100));
        LinkedList.printCyclicList(cyclicList);
    }
}
