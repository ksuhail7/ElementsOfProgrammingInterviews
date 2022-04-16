//
// Created by Suhail Kandanur on 2022-03-29.
//

#include <iostream>
#include <vector>

void rearrange(std::vector<int>& sequence, int pivot) {
    // invariants
    // [0, small): integers less than pivot
    // [small, equals): integers equal to pivot
    // [equals, n) : integers greater than pivot
    if(sequence.size() < 1) return;
    int small = 0, equals = 0, largest = sequence.size() - 1;

    while(equals <= largest) {
        if(sequence[equals] < pivot) {
            int temp = sequence[small];
            sequence[small] = sequence[equals];
            sequence[equals] = temp;
            small++;
            equals++;
        } else if (sequence[equals] == pivot) {
            equals++;
        } else {
            int temp = sequence[largest];
            sequence[largest] = sequence[equals];
            sequence[equals] = temp;
            largest--;
        }
    }
}

int main(int argc, char *argv[]) {
    std::vector<int> sequence = {5, 3, 7, 11, 2, 3, 13, 5, 7};
    int pivot = 7;
    rearrange(sequence, pivot);
    for (int i = 0; i < sequence.size(); ++i) {
        std::cout << sequence[i] << " ";
    }
    std::cout << std::endl;
    return 0;
}


