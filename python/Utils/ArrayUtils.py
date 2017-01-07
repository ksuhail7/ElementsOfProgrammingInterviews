import random


class ArrayUtils:
    def getRandomArray(size, min, max):
        return [random.randint(min, max) for x in range(0, size)]
