//
// Created by Suhail Kandanur on 2022-04-16.
//

#include <iostream>
#include <vector>
#include <memory>
#include <functional>

template <typename T> struct BSTNode;
template <typename T> using BSTNodePtr = std::unique_ptr<BSTNode<T>>;

template <typename T> struct BSTNode {
    T data;
    BSTNodePtr<T> left, right;

    BSTNode(T data, BSTNodePtr<T> left, BSTNodePtr<T> right) : data(data), left(std::move(left)), right(std::move(right)) {}

    void printTree() {
        if(left != nullptr) {
            left->printTree();
        }
        std::cout << data << " ";
        if(right != nullptr) {
            right->printTree();
        }
    }

    bool isValidBST(const T& min, const T& max) {
        bool dataWithinLimits = (data >= min) && (data <= max);
        bool isLeftValid = (left != nullptr) ? (data >= left->data) && left->isValidBST(min, data) : true;
        bool isRightValid = (right != nullptr) ? (data <= right->data) && right->isValidBST(data, max) : true;
        return dataWithinLimits && isLeftValid && isRightValid;

    }
};

template <typename T> BSTNodePtr<T> buildTree(const std::vector<T>& values, int forNodeAt, std::function<bool (const T&)> isNullValue) {
    if(forNodeAt >= values.size()) return nullptr;
    T currNode = values[forNodeAt];
    if(isNullValue(currNode)) return nullptr;
    return std::make_unique<BSTNode<T>>(currNode, std::move(buildTree(values, forNodeAt * 2 + 1, isNullValue)), std::move(buildTree(values, forNodeAt * 2 + 2, isNullValue)));

}
template <typename T> BSTNodePtr<T> buildBST(const std::vector<T>& values, std::function<bool (const T&)> isNullValue) {
    return buildTree(values, 0, isNullValue);
}

int main(int argc, char *argv[]) {
    std::vector<int> data = {19, 7, 43, 3, 11, 23, 47, 2, 5, -1, 17, 20, 37, -1, 53, -1,-1,-1,-1, -1, -1, 12, -1, -1,-1, 29,41, -1,-1,-1,-1};
    std::function<bool (const int&)> isNullValue = [] (const int& value) { return value == -1;};
    BSTNodePtr<int> root = buildBST(data, isNullValue);
    root->printTree();
    std::cout << "Valid BST: " << root->isValidBST(INT_MIN, INT_MAX) << std::endl;
    return 0;
}
