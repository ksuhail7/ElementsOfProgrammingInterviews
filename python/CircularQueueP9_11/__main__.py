#!/usr/bin/env python3
class CircularQueue:
    def __init__(self, size):
        self.sz = size
        self.array = [None] * size
        self.head = 0
        self.tail = 0
        self.count = 0

    def enque(self, element):
        if self.is_full():
            raise "queue is full"
        self.array[self.tail] = element
        self.tail = (self.tail + 1) % self.sz
        self.count += 1

    def deque(self):
        element = None
        if self.is_empty():
            raise "queue is empty"
        element = self.array[self.head]
        self.head = (self.head + 1) % self.sz
        self.count -= 1
        return element

    def size(self):
        return self.count

    def is_empty(self):
        return self.count == 0

    def is_full(self):
        return self.count == self.sz


cq = CircularQueue(10)
cq.enque(3)
cq.enque(4)
cq.enque(5)
cq.enque(8)
cq.enque(3)
print(cq.deque())
print(cq.deque())
print(cq.deque())
cq.enque(7)
cq.enque(9)
cq.enque(58)
cq.enque(87)
cq.enque(80)
cq.enque(80)
cq.enque(80)
print(cq.deque())
print(cq.deque())
print(cq.deque())
print(cq.size())
print("done")
