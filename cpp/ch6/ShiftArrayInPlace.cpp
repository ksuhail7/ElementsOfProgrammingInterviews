//
// Created by Suhail Kandanur on 2022-03-30.
//

#include <iostream>
#include <vector>

void reverse(std::vector<int>& seq, int start, int end) {
    while(start < end) {
        int temp = seq[start];
        seq[start++] = seq[end];
        seq[end--] = temp;
    }
}
void rotateInPlace(std::vector<int>& seq, int byPositions) {
    // byPositions > 0: rotate right
    // byPositions < 0: rotate left
    // example 1: byPositions = 3 (rotate right)
    // (9 + 3) % 9 = 3
    // output: 7, 8, 9, 1, 2, 3, 4, 5, 6
    // step 1: 9, 8, 7, 6, 5, 4, 3, 2, 1
    // step 2: reverse [0, 2]
    // step 3: reverse [3, 8]

    // example 2: byPositions = -3 (rotate left)
    // length: 9
    // (9 - 3) % 9 = 6
    // output: 4, 5, 6, 7, 8, 9, 1, 2, 3
    // step 1: 9, 8, 7, 6, 5, 4, 3, 2, 1
    // step 2: reverse [0, 5]
    // step 3: reverse [6, 8]
    reverse(seq, 0, seq.size()-1);
    int splitPos = (seq.size() + byPositions) % seq.size();
    reverse(seq, 0, splitPos - 1);
    reverse(seq, splitPos, seq.size() - 1);
}

int main(int argc, char *argv[]) {
    std::vector<int> seq = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int positions = -3;
    rotateInPlace(seq, positions);
    for (int i = 0; i < seq.size(); ++i) {
        std::cout << seq[i] << " ";
    }
    std::cout << std::endl;
    return 0;
}

