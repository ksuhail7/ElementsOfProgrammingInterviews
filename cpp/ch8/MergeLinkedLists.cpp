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

NodePtr mergeLists(const NodePtr head1, const NodePtr head2) {
    NodePtr it1 = head1, it2 = head2;
    NodePtr mergeHead = nullptr, it = nullptr;
    while (it1 != nullptr || it2 != nullptr) {
        NodePtr picked = nullptr;
        if ((it1 == nullptr) || (it1->data >= it2->data)) {
            picked = it2;
            it2 = it2->next;
        } else {
            picked = it1;
            it1 = it1->next;
        }

        if (mergeHead == nullptr) {
            mergeHead = picked;
        }

        if (it != nullptr) {
            it->next = picked;
        }
        it = picked;
    }

    it->next = nullptr;
    return mergeHead;
}

int main(int argc, char *argv[]) {
    std::vector<int> seq1 = {2, 5, 7};
    std::vector<int> seq2 = {3, 11, 13};
    NodePtr head1 = buildList(seq1);
    NodePtr head2 = buildList(seq2);

    printList(head1);
    printList(head2);

    NodePtr mergedHead = mergeLists(head1, head2);
    printList(mergedHead);
    return 0;
}
