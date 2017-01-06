#!/usr/bin/env python3

def charToInt(char):
    ch = 'A'
    return ord(char) - ord(ch) + 1


columnId = "A"
sum = 0
for i in range(0, len(columnId)):
    char = columnId[len(columnId) - 1 - i]
    sum += (26 ** i) * charToInt(char)

print(sum)
