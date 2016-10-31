package com.suhailkandanur.eopi.ch8;

import com.suhailkandanur.eopi.util.Node;

/**
 * Created by suhail on 2016-10-30.
 */
public class LinkedListsP8_1 {
    public static Node merge(Node list1, Node list2) {
        Node head1 = list1;
        Node head2 = list2;
        Node newHead = null, ptr = null;

        while(head1 != null && head2 != null) {
            Node smaller = null;
            if(head1.getData() > head2.getData()) {
                smaller = head2;
                head2 = head2.getNext();
            } else {
                smaller = head1;
                head1 = head1.getNext();
            }
            if(newHead == null) {
                newHead = smaller;
            } else {
                ptr.setNext(smaller);
            }
            ptr = smaller;
        }
        if(head1 != null && newHead != null)
            ptr.setNext(head1);
        else if(head2 != null && newHead != null) {
            ptr.setNext(head2);
        }
        return newHead;
    }
}
