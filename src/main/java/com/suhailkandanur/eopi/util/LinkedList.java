package com.suhailkandanur.eopi.util;

import java.util.Random;

/**
 * Created by suhail on 2016-10-30.
 */
public interface LinkedList {
    static void printLinkedList(Node node) {
        if (node == null)
            return;
        while (node != null) {
            System.out.print(node.getData() + " -> ");
            node = node.getNext();
        }
        System.out.println("NULL");
    }

    static int length(Node node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.getNext();
        }
        return len;
    }

    static Node createList(int[] list) {
        Node head = null;
        Node ptr = null;
        for (int val : list) {
            Node node = new Node(val);
            if (head == null) {
                head = node;
            } else {
                ptr.setNext(node);
            }
            ptr = node;
        }
        return head;
    }

    static Node createCyclicList(int[] list) {
        Node head = createList(list);
        //get a random element between 1 and list.length -1 to create a cycle
        int rand = new Random().nextInt(list.length) + 1;
        Node ptr = head;
        for (int i = 0; i < rand; i++) {
            ptr = ptr.getNext();
        }
        Node last = head;
        while (last != null && last.getNext() != null) {
            last = last.getNext();
        }
        if (last != null) {
            last.setNext(ptr);
        }
        return head;
    }

    static Node cycleStartNode(Node head) {
        Node slowPtr = head;
        Node fastPtr = head.getNext();
        while (slowPtr != null && fastPtr != null && slowPtr != fastPtr) {
            if (slowPtr != null)
                slowPtr = slowPtr.getNext();
            if (fastPtr != null && fastPtr.getNext() != null)
                fastPtr = fastPtr.getNext().getNext();
        }
        if (slowPtr != null && fastPtr != null) {
            int noOfNodesInCycle = 1;
            slowPtr = slowPtr.getNext();
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.getNext();
                noOfNodesInCycle++;
            }

            slowPtr = head; fastPtr = head;
            for (int i = 0; i < noOfNodesInCycle; i++) {
                fastPtr = fastPtr.getNext();
            }
            while(slowPtr != fastPtr) {
                slowPtr = slowPtr.getNext();
                fastPtr = fastPtr.getNext();
            }
        }
        return (slowPtr == null || fastPtr == null) ? null : slowPtr;
    }

    static void printCyclicList(Node head) {
        Node cycleStart = cycleStartNode(head);
        if (cycleStart == null) {
            printLinkedList(head);
        } else {
            int count = 0;
            Node ptr = head;
            while (count < 2) {
                if (ptr == cycleStart) {
                    count++;
                }
                if (ptr != null) {
                    System.out.print(ptr.getData() + "->");
                    ptr = ptr.getNext();
                }
            }
            System.out.println();
        }
    }

    static int compare(Node list1, Node list2) {
        int len1 = length(list1);
        int len2 = length(list2);
        if (len1 != len2)
            return len1 > len2 ? +1 : -1;
        else {
            //compare elements
            while (list1 != null && list2 != null) {
                if (list1.getData() != list2.getData())
                    return -1;
                list1 = list1.getNext();
                list2 = list2.getNext();
            }
        }
        return 0;
    }
}
