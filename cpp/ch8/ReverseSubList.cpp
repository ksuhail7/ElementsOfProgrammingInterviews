//
// Created by Suhail Kandanur on 2022-04-16.
//
#include <vector>
#include <iostream>

struct Node;
typedef std::shared_ptr<Node> NodePtr;

struct Node {
    int data;
    NodePtr next;

    Node(int data) : data(data), next(nullptr) {}

};

void printList(const NodePtr &head) {
    NodePtr it = head;
    while (it != nullptr) {
        std::cout << it->data << " ";
        it = it->next;
    }
    std::cout << std::endl;
}

NodePtr buildList(const std::vector<int> &seq) {
    if (seq.size() < 1) return nullptr;
    NodePtr head = nullptr, it = nullptr;
    for (int val: seq) {
        NodePtr newNode = std::make_shared<Node>(val);
        if (head == nullptr) {
            head = newNode;
        }
        if (it != nullptr) {
            it->next = newNode;
        }
        it = newNode;
    }
    return head;
}

NodePtr reverseListInPlace(const NodePtr head, int from, int to) {
    NodePtr it = head;
    int counter = 1;
    NodePtr start, newHead = nullptr, end = nullptr;
    NodePtr reverseHead = nullptr;
    while (it != nullptr) {
        NodePtr curr = it;
        it = it->next;
        if(counter < from) {
            start = curr;
            newHead = head;
        } else if (counter >= from && counter <= to) {
            if(end == nullptr) end = curr;
            curr->next = reverseHead;
            reverseHead = curr;
            start->next = curr;
        } else {
            it = curr;
            break;
        }
        counter++;
    }
    if(end != nullptr) {
        end->next = it;
    }
    if(newHead == nullptr) {
        newHead = reverseHead;
    }

    return newHead;
}

// from: 3, to: 5
// 2 -> 5 -> 7 -> 4 -> 13 -> 9 -> 10 -> null
// 2 -> 5 -> 7
// 2 -> 5 -> 13 -> 4 -> 7 -> 9 -> 10 -> null

//
int main(int argc, char *argv[]) {
    std::vector<int> seq = {2, 5, 7, 4, 13, 9, 10};
    NodePtr head = buildList(seq);

    printList(head);

    int from = 3, to = 6;
    NodePtr reverseHead = reverseListInPlace(head, from, to);
    printList(reverseHead);

    return 0;
}
