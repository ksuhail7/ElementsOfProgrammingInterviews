class Node:
    def __init__(self, data, next=None, prev=None):
        self.data = data
        self.next = next
        self.previous = prev

    def getNext(self):
        return self.next

    def getPrevious(self):
        return self.previous

    def getData(self):
        return self.data

    def setNext(self, next):
        self.next = next

    def setPrevious(self, prev):
        self.previous = prev

