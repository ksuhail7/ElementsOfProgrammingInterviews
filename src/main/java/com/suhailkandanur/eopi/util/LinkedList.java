package com.suhailkandanur.eopi.util;

/**
 * Created by suhail on 2016-10-30.
 */
public interface LinkedList {
    static void printLinkedList(Node node) {
        if(node == null)
            return;
        while(node != null) {
            System.out.print(node.getData() + " -> ");
            node = node.getNext();
        }
        System.out.println("NULL");
    }

    static int length(Node node) {
        int len = 0;
        while(node != null) {
            len++;
            node = node.getNext();
        }
        return len;
    }

    static Node createList(int[] list) {
        Node head = null;
        Node ptr = null;
        for(int val: list) {
            Node node = new Node(val);
            if(head == null) {
                head = node;
            } else {
                ptr.setNext(node);
            }
            ptr = node;
        }
        return head;
    }

    static int compare(Node list1, Node list2) {
        int len1 = length(list1);
        int len2 = length(list2);
        if(len1 != len2)
            return len1 > len2 ? +1 : -1;
        else {
            //compare elements
            while(list1 != null && list2 != null) {
                if(list1.getData() != list2.getData())
                    return -1;
                list1 = list1.getNext();
                list2 = list2.getNext();
            }
        }
        return 0;
    }
}
