package com.suhailkandanur.eopi.util;

/**
 * Created by suhail on 2016-10-30.
 */
public class LinkedList {
    public static void printLinkedList(Node node) {
        if(node == null)
            return;
        while(node != null) {
            System.out.print(node.getData() + " -> ");
            node = node.getNext();
        }
        System.out.println("NULL");
    }

    public static int length(Node node) {
        int len = 0;
        while(node != null) {
            len++;
            node = node.getNext();
        }
        return len;
    }
}
