package com.suhailkandanur.eopi.ch8;

import com.suhailkandanur.eopi.util.LinkedList;
import com.suhailkandanur.eopi.util.Node;

/**
 * Problem 8.3: Write a function which takes a singly linked list L and two integers s and f as arguments,
 * and reverses the order of the nodes from the s-th node to f-th node, inclusive. The numbering begins 1,
 * ie. the head node is the first node. Perform the reversal in single pass. Do not allocate additional nodes.
 * <p>
 * Created by suhail on 2016-11-15.
 */
public class ReverseSubListP8_3 {

    public static  Node reverseSubList(Node head, int start, int finish) {
        if (head == null || start < 1 || finish < 1 || finish < start) return null;
        Node newHead = head;
        // position newhead at s-th node
        while (newHead != null && --start > 1) {
            newHead = newHead.getNext();
        }
        Node sMinusOneNode = newHead;
        System.out.println("(s-1)" + sMinusOneNode.getData());
        Node tail =null, p = null;
        if (newHead == null)
            return head;
        newHead = newHead.getNext();
        int len = (finish - start);
        while (newHead != null && --len > 1) {
            if(tail == null) tail = newHead;
            Node q = newHead;
            newHead = newHead.getNext();
            q.setNext(p);
            p = q;
            System.out.println("p" + p.getData());
        }
        System.out.println("Tail: " + tail.getData());
        System.out.println("new head: " + newHead.getData());
        if (newHead != null) {
            sMinusOneNode.setNext(newHead);
            tail.setNext(newHead.getNext());
        }
        return head;
    }

    public static void main(String[] args) {
        int[] a = new int[] {2, 7, 1, 0, 3, 4, 9, 5};
        final Node list = LinkedList.createList(a);
        Node newList = reverseSubList(list, 3, 6);
        LinkedList.printLinkedList(newList);
    }
}
