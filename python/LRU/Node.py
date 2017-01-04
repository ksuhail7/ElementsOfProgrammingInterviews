class Node:
	
	def __init__(self, key, value, next=None, previous=None):
		self.key = key
		self.value = value
		self.next = next
		self.previous = previous

	def getKey(self):
		return self.key

	def getValue(self):
		return self.value

	def getNext(self):
		return self.next

	def getPrevious(self):
		return self.previous

	def setNext(self, next):
		self.next = next

	def setPrevious(self, previous):
		self.previous = previous

		
