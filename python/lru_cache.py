#!/usr/bin/env python3
from LRU import LRU

datasource = {1:"one", 2:"two", 3:"three", 4: "four", 5: "five", 6: "six", 7: "seven", 8: "eight", 9: "nine", 10: "ten"}

lru = LRU(4, datasource)
print(lru.get(1))
print(lru.get(2))
print(lru.get(3))
print(lru.get(4))
print(lru.get(6))
print(lru.get(3))
print(lru.get(6))
print(lru.get(1))
print(lru.get(2))
print(lru.get(5))

