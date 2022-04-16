//
// Created by Suhail Kandanur on 2022-03-26.
//

#include <vector>
#include <map>
#include <iostream>

using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> result = {};
    std::map<int, int> m;
    for(int i = 0; i < nums.size(); ++i) {
        m[nums[i]] = i;
    }
    for(int i = 0; i < nums.size(); ++i) {
        int first = nums[i];
        int second = target - first;
        auto search = m.find(second);
        if(search != m.end() && search->second != i) {
            result.emplace_back(i);
            result.emplace_back(search->second);
            break;
        }
    }
    return result;
}
int main(int argc, char *argv[]) {
//    vector<int> v = {2, 7, 11, 15};
vector<int> v = {3, 2, 4};
    int target = 6;
    auto result = twoSum(v, target);
    std::for_each(result.cbegin(), result.cend(),  [] (const int f){
        std::cout << f << " ";
    });
    std::cout << std::endl;
    return 0;
}
