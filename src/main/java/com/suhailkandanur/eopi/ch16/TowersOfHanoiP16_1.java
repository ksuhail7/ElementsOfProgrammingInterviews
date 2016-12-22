package com.suhailkandanur.eopi.ch16;

import java.util.Stack;

/**
 * Created by suhail on 2016-12-22.
 */
public class TowersOfHanoiP16_1 {
    public static void main(String[] args) {
        int n = 3;
        for (int i = n; i > 0; i--) {
            Tower.P1.push(i);
        }
        for (int i = 0; i < n
                ; i++) {
            System.out.println(Tower.P1.get(i));
        }
        move(Tower.P1, Tower.P2, Tower.P3, n);
        for (int i = 0; i < n; i++) {
            System.out.println(Tower.P2.get(i));
        }
    }

    private static void move(Tower from, Tower to, Tower intermediate, int n) {
        if (n == 0)
            return;
        move(from, intermediate, to, n - 1);
        int fr = from.peek();
        System.out.println("pushing " + fr + " from " + from.getId() + " to " + to.getId());
        to.push(from.pop());
        move(intermediate, to, from, n - 1);
    }

    private static enum Tower {
        P1("p1", new Stack<>()), P2("p2", new Stack<>()), P3("p3", new Stack<>());

        private final String id;
        private final Stack<Integer> stack;

        private Tower(final String id, final Stack<Integer> stack) {
            this.id = id;
            this.stack = stack;
        }

        public int pop() {
            return this.stack.pop();
        }

        public void push(int value) {
            this.stack.push(value);
        }

        public int peek() {
            return this.stack.peek();
        }

        public String getId() {
            return this.id;
        }

        public int get(int index) {
            return this.stack.get(index);
        }
    }
}
