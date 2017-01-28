#!/usr/bin/env python3

def int_sqrt(number):
    return binary_search(number, 0, int(number / 2))


def binary_search(number, lo, hi):
    print("lo", lo, "hi", hi)
    if lo > hi:
        return -1
    mid = lo + int((hi - lo) / 2)
    if (mid * mid) < number:
        num = binary_search(number, mid + 1, hi)
        return num if num is not -1 else mid
    elif (mid * mid) > number:
        return binary_search(number, lo, mid - 1)
    else:
        return mid


n = 1
print(int_sqrt(n))
