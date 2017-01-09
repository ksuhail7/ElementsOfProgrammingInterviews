#!/usr/bin/env python3

num = [1, 9, 9]

carry = 1
for i in range(0, len(num)):
    ndx = len(num) - i - 1
    x = num[ndx]
    x += carry
    carry = int(x / 10)
    x %= 10
    num[ndx] = x
if carry is not 0:
    num.append(0)
    for i in range(1, len(num)):
        num[len(num) - i] = num[len(num) - i - 1]
    num[0] = carry
print(num)
