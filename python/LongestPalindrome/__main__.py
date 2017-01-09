#!/usr/bin/env python3

def longest_palindrome(string):
    return longest_palindrome_aux(string, string[::-1], len(string), len(string))


def longest_palindrome_aux(string1, string2, n, m):
    if n == 0 or m == 0:
        return ""
    if string1[n - 1] == string2[m - 1]:
        substring = longest_palindrome_aux(string1, string2, n - 1, m - 1)
        return substring + string1[n - 1]
    else:
        substring1 = longest_palindrome_aux(string1, string2, n - 1, m)
        substring2 = longest_palindrome_aux(string1, string2, n, m - 1)
        if len(substring1) > len(substring2):
            return substring1
        else:
            return substring2


string = "character"
print(longest_palindrome(string))
