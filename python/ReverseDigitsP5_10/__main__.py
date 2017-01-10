#!/usr/bin/env python3

def reverseDigits(num):
	reverseNum = 0
	isNeg = False
	if num < 0:
		isNeg = True
		num = -num
	while num > 0:
		x = num % 10
		reverseNum = (reverseNum * 10) + x
		num = int(num / 10)
	if isNeg:
		return -reverseNum
	else:
		return reverseNum


x = -150
print(reverseDigits(x))
print("hello")
