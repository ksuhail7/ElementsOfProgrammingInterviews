package com.suhailkandanur.eopi.ch9.test;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.suhailkandanur.eopi.ch9.StackP9_1.*;
import static org.apache.coyote.http11.Constants.a;

/**
 * Created by suhail on 2016-11-02.
 */
public class StackP9_1Test {
    @Test
    public void testMax() throws Exception {
        Stack stack = new Stack(10);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        assertEquals(4, stack.max());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.max());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.max());
    }

    @Test(expected = Exception.class)
    public void testEmpty() throws Exception {
        Stack stack = new Stack(10);
        stack.pop();
    }

}
