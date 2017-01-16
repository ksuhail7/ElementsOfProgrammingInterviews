#!/usr/bin/env python3

import random
from queue import PriorityQueue

q = PriorityQueue()

min = 0
max = 100
size = 10
array = [random.randint(min, max) for x in range(0, size)]

for element in array:
    q.put((-element, element))

while q.empty() is False:
    print(q.get()[1])
