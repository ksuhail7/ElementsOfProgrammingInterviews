//
// Created by Suhail Kandanur on 2022-04-22.
//

#include <vector>
#include <iostream>

// p1 (1...n), p2 (int), p3 --> p1, p2 (int), p3(1..n)

// p1(n), p2(1..n-1), p3 --> p1, p2(1..n-1), p3(n) -->
void move(int from, int to, int intermediate, int numberOfRings) {
    if(numberOfRings < 1) return;
    move(from, intermediate, to, numberOfRings -1);
    std::cout << "Moving ring " << numberOfRings << " from peg" << from << " to peg" << to << std::endl;
    move(intermediate, to, from, numberOfRings - 1);
}

int main(int argc, char *argv[]) {
    int numberOfRings = 20;
    int from = 1, to = 3, intermediate =2;
    move(from, to, intermediate, numberOfRings);
    return 0;
}