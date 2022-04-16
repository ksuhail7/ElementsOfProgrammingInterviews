//
// Created by Suhail Kandanur on 2022-03-29.
//

#include <iostream>
#include <vector>

void incrementInPlace(std::vector<int>& d) {
    int carry = 1;
    for(int i = d.size() - 1; i >= 0; --i) {
        int sum = d[i] + carry;
        d[i] = sum % 10;
        carry = sum / 10;
    }
    if(carry > 0) {
        d.emplace(d.begin(), carry);
    }
}
int main(int argc, char *argv[]) {
    std::vector<int> d = {9, 9, 9};
    incrementInPlace(d);
    for (int i = 0; i < d.size(); ++i) {
        std::cout << d[i];
    }
    std::cout << std::endl;
    return 0;
}
