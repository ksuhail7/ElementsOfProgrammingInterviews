//
// Created by Suhail Kandanur on 2022-04-19.
//
#include <iostream>
#include <vector>

struct StackNode {
    int value;
    int max;
};

struct Stack {
    std::vector<StackNode> stack;

    int max() {
        if(stack.empty()) {
            throw std::runtime_error("stack is empty");
        }
        return stack.at(stack.size() - 1).max;
    }

    void push(int value) {
        int currMax = (stack.empty() || stack.at(stack.size() - 1).max < value) ? value : stack.at(stack.size() - 1).max;
       stack.push_back(StackNode {.value = value, .max = currMax});
    }

    int pop() {
        auto last = stack.back();
        stack.pop_back();
        return last.value;

    }
};

int main(int argc, char *argv[]) {
    Stack stack;
    stack.push(2);
    stack.push(1);
    stack.push(4);
    std::cout << "Max so far: " << stack.max() << std::endl;
    std::cout << "Element popped: " << stack.pop() << std::endl;
    stack.push(3);
    std::cout << "Element popped: " << stack.pop() << std::endl;
    std::cout << "Max so far: " << stack.max() << std::endl;

    return 0;
}