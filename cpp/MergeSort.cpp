//
// Created by Suhail Kandanur on 2022-03-19.
//

#include <iostream>
#include <vector>
#include <random>


std::vector<int> merge_sort_helper(const std::vector<int>& a , int start, int end) {
    if(start > end) return std::vector<int>(0);
    if(start == end) return {a[start]};fi
    int mid = start + (end - start) / 2;
    std::cout << "sorting: " << start << "->" << end << "(mid: " << mid << ")" << std::endl;
    std::vector<int> left = merge_sort_helper(a, start, mid-1);
    std::vector<int> right = merge_sort_helper(a, mid, end);
    std::vector<int> sorted;
    int i = 0, j = 0;
    while(i < left.size() || j < right.size()) {
        if(j< right.size() && left[i] > right[j]) {
            sorted.emplace_back(right[j]);
            j++;
        } else {
            sorted.emplace_back(left[i]);
            i++;
        }
    }
    return sorted;
}
std::vector<int> merge_sort(const std::vector<int>& a) {
    return merge_sort_helper(a, 0, a.size() - 1);
}

int binary_search_helper(const std::vector<int>& arr, int start, int end, int k) {
    if(start > end) return -1;
    int mid = start + (end - start) / 2;
    if(arr[mid] == k) {
        return mid;
    } if(arr[mid] > k) {
        return binary_search_helper(arr, start, mid - 1, k);
    } else {
        return binary_search_helper(arr, mid + 1, end, k);
    }
}
int binary_search(const std::vector<int>& arr, int k) {
    return binary_search_helper(arr, 0, arr.size() - 1, k);
}

int main(int argc, char** argv) {
    std::random_device rd;
    std::mt19937 g(rd());
    int n = 10;
    std::vector<int> a;
    for (int i = 0; i < n; ++i) {
        a.emplace_back(i);
    }
    std::shuffle(a.begin(), a.end(), g);
//    std::sort(a.begin(), a.end());
    for (int i = 0; i < a.size(); ++i) {
        std::cout << i << " -> " << a[i] << " ";
    }
    std::cout << std::endl;
//    int k = 9;
//    int ndx = binary_search(a, k);
//    if(ndx != -1) {
//        std::cout << "Found " << k << " at index " << ndx << " (value: " << a[ndx] << ")" << std::endl;
//    } else {
//        std::cout << k << " not found" << std::endl;
//    }

    auto sorted = merge_sort(a);
    std::cout << "Sorted: ";
    for (int i = 0; i < sorted.size(); ++i) {
        std::cout << sorted[i] << " ";
    }
    std::cout << std::endl;
}
