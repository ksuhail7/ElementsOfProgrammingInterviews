package com.suhailkandanur.eopi.ch8.test;

import com.suhailkandanur.eopi.ch8.LinkedListsP8_1;
import com.suhailkandanur.eopi.ch8.LinkedListsP8_2;
import com.suhailkandanur.eopi.util.LinkedList;
import com.suhailkandanur.eopi.util.Node;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by suhail on 2016-11-01.
 */
public class LinkedListP8_2Test {
    @Test
    public void testReverseList() {
        int[] list = {1, 2, 3, 4};
        Node head = LinkedList.createList(list);
        LinkedList.printLinkedList(head);
        Node newhead = LinkedListsP8_2.reverseList(head);
        LinkedList.printLinkedList(newhead);
        LinkedList.printLinkedList(LinkedListsP8_2.reverseList(newhead));
    }


}
