package com.suhailkandanur.eopi.ch8.test;

import com.suhailkandanur.eopi.ch8.LinkedListsP8_1;
import com.suhailkandanur.eopi.util.LinkedList;
import com.suhailkandanur.eopi.util.Node;
import org.junit.Before;
import org.junit.Test;

import static com.suhailkandanur.eopi.util.LinkedList.length;
import static org.junit.Assert.assertEquals;

/**
 * Created by suhail on 2016-10-30.
 */
public class LinkedListsP8_1Test {
    private Node head1 = null;
    private Node head2 = null;

    @Before
    public void setUpLinkedLists() {
        int[] list1 = {2, 4, 6, 7, 10, 18};
        int[] list2 = {1, 2, 3, 5, 8, 11, 12, 14};
        head1 = LinkedList.createList(list1);
        head2 = LinkedList.createList(list2);

    }

    @Test
    public void testMerge() {
        LinkedList.printLinkedList(head1);
        LinkedList.printLinkedList(head2);
        int expected = length(head1) + length(head2);
        Node mergeList = LinkedListsP8_1.merge(head1, head2);
        assertEquals(expected , length(mergeList));
        LinkedList.printLinkedList(mergeList);
    }

    @Test
    public void testNullLists() {
        int expected = 0;
        Node mergeList = LinkedListsP8_1.merge(null, null);
        assertEquals(expected, length(mergeList));
    }

}
