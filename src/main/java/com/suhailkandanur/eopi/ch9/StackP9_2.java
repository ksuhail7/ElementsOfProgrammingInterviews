package com.suhailkandanur.eopi.ch9;

/**
 * Created by suhail on 2016-11-02.
 */
public class StackP9_2 {
    static class Stack {
        char[] rpn = new char[100];
        int top;
        int size;

        public Stack(int size)  {
            this.size = size;
            this.top = -1;
        }

        public void push(char c) throws Exception {
            if(top == size - 1) throw new Exception("stack is full");
            rpn[++top] = c;
        }

        public char pop() throws Exception {
            if(top < 0) throw new Exception("stack is empty");
            return rpn[top--];
        }

        public char peek() throws Exception {
            if(top < 0) throw new Exception("stack is empty");
            return rpn[top];
        }
    }

    public int evaluate(Stack stack) throws Exception {
        char c = stack.pop();
        if(Character.isDigit(c))
            return c;
        if(c == '+' || c == '-' || c == '*' || c == '/') {
            int op1, op2;
            if(Character.isDigit(stack.peek())) {
                op1 = stack.pop();
            } else {
                op1 = evaluate(stack);
            }

            if(Character.isDigit(stack.peek())) {
                op2 = stack.pop();
            } else {
                op2 = evaluate(stack);
            }
            switch(c) {
                case '+': return op1 + op2;
                case '-': return op1 - op2;
                case '*': return op1 * op2;
                case '/': return op1 / op2;
            }
        }
        return 0;
    }

}
