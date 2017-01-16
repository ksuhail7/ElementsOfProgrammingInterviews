class CircularQueue:
    def __init__(self, size):
        self.size = size
        self.array = [None] * size
        self.head = -1
        self.tail = -1

    def enque(self, element):
        if self.is_full():
            raise "queue is full"
        if self.head == -1:
            self.head = 0
        self.tail = (self.tail + 1) % self.size
        self.array[self.tail] = 1

    def deque(self):
        element = None
        if not self.is_empty():
            element = self.array[self.head]
            if self.head == self.tail:
                self.head = -1
                self.tail = -1
            return element
        raise "queue is empty"

    def size(self):
        return abs((self.tail + 1) % self.size - self.head)

    def is_empty(self):
        return self.head == -1 and self.tail == -1

    def is_full(self):
        return (self.tail + 1) % self.size == self.head
