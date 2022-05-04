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
        std::cout << "creating new node for " << val << std::endl;
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

NodePtr reverseListInPlace(const NodePtr head) {
    NodePtr reverseHead = nullptr;
    NodePtr it = head;

    while(it != nullptr) {
        NodePtr curr = it;
        it = it->next;
        curr->next = reverseHead;
        reverseHead = curr;

    }
    return reverseHead;
}
int main(int argc, char *argv[]) {
    std::vector<int> seq = {2, 5, 7, 4, 13, 9, 10};
    NodePtr head = buildList(seq);

    printList(head);

    NodePtr reverseHead = reverseListInPlace(head);
    printList(reverseHead);

    return 0;
}
