//
// Created by Suhail Kandanur on 2022-03-29.
//

#include <iostream>
#include <vector>

int deleteKeyInPlace(std::vector<int>& seq, int key) {
    int equal = 0, largest = seq.size() - 1;
    while (equal <= largest) {
        if(seq[equal] == key) {
            int temp = seq[largest];
            seq[largest--] = seq[equal];
            seq[equal] = temp;
        } else {
            equal++;
        }
    }
    return equal;
}

int deleteShiftInPlace(std::vector<int>& seq, int key) {
    std::vector<int> shifts = {};
    int counter = 0;
    for (int i = 0; i < seq.size(); ++i) {
        shifts.emplace_back(counter);
        if(seq[i] == key) {
            counter++;
        }
    }
    std::cout << std::endl;
    for (int i = 1; i < seq.size(); ++i) {
        if(shifts[i] <= i) {
            seq[i - shifts[i]] = seq[i];
        }
    }
    return seq.size() - counter;
}

int main(int argc, char *argv[]) {
    std::vector<int> seq = {5, 3, 7, 11, 2, 3, 13, 5, 7};
    int key = 3;
    int newLength = deleteShiftInPlace(seq, key);
    for (int i = 0; i < newLength; ++i) {
        std::cout << seq[i] << " ";
    }
    std::cout << std::endl;
    return 0;
}

