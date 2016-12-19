#!/usr/bin/env python3

def longestParanMatch(s):
    max = ""
    str = ""
    stack = []
    for c in s:
    	if len(stack) > 0 and ((c == ')' and stack[-1] == '(') or (c == ']' and stack[-1] == '[') or (c == '}' and  stack[-1] == '{')):
    		str = stack.pop() + str + c
    	else:
    		if len(str) > len(max):
    			max = str;
    			str = ""
    		stack.append(c)
    if len(str) > len(max):
    	return str
    else:
    	return max

s="((())()(()("
print(longestParanMatch(s))

