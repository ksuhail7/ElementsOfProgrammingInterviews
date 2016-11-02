package com.suhailkandanur.eopi.ch8;

import com.suhailkandanur.eopi.util.Node;

/**
 * Created by suhail on 2016-11-01.
 */
public class LinkedListsP8_2 {
    public static Node reverseList(Node head) {
        Node newHead = null;
        Node p = null;
        while(head != null) {
            newHead = head;
            head = head.getNext();
            newHead.setNext(p);
            p = newHead;
        }
        return newHead;
    }
}
