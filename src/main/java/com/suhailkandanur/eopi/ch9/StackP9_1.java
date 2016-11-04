package com.suhailkandanur.eopi.ch9;

import static com.sun.tools.doclint.Entity.ne;
import static sun.jvm.hotspot.oops.CellTypeState.top;

/**
 * Created by suhail on 2016-11-01.
 */
public class StackP9_1 {
    static class StackNode {
        private int data;
        private int max;

        public StackNode(int data, int max) {
            this.data = data;
            this.max = max;
        }

        public int getData() {
            return data;
        }

        public int getMax() {
            return max;
        }
    }
    public static class Stack {
        private StackNode[] array = new StackNode[100];
        private int top;
        private final int size;
        public Stack(int size) {
            this.size = size;
            this.top = -1;
        }
        public int pop() throws Exception {
            if(top < 0) throw new Exception("empty stack");
            return array[top--].getData();
        }

        public void push(int data) throws Exception {
            if(top == size-1) throw new Exception("stack is full");
            int maxSoFar = (top < 0) ? 0 : array[top].getMax();
            StackNode newNode = new StackNode(data, maxSoFar > data ? maxSoFar : data);
            array[++top] = newNode;
        }

        public int max() throws Exception {
            if(top < 0) throw new Exception("empty stack");
            return array[top].getMax();
        }
    }
}
