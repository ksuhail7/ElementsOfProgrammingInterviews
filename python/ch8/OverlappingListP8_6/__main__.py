#!/usr/bin/env python3
import random

class Node:

	def __init__(self, data, next=None):
		self.data = data
		self.next = next

	def getData(self):
		return self.data

	def getNext(self):
		return self.next

	def setNext(self, next):
		self.next = next


def create_list(list):
	head = None
	ptr = None
	for element in list:
		node = Node(element)
		if head is None:
			head = node

		if ptr is not None:
			ptr.setNext(node)
		ptr = node
	return head

def print_list(head):
	ptr = head
	while ptr is not None:
		print(ptr.getData(), end="->")
		ptr = ptr.getNext()
	print()

def append_list(list1, list2):
	new_list = list1
	ptr = list1
	while ptr is not None and ptr.getNext() is not None:
		ptr = ptr.getNext()
	if ptr is not None:
		ptr.setNext(list2)
	else:
		ptr = list2
	return new_list if list1 is not None else list2 

def length(list):
	sz = 0
	ptr = list
	while ptr is not None:
		ptr = ptr.getNext()
		sz+=1
	return sz


def find_common_node(list1, list2):
	l1 = length(list1)
	l2 = length(list2)

	diff = abs(l1-l2)	
	if l1 >= l2:
		ptr1 = list1
		ptr2 = list2
	else:
		ptr1 = list2
		ptr2 = list1

	while diff > 0:
		ptr1 = ptr1.getNext()
		diff-=1

	common = None

	while ptr1 is not None and ptr2 is not None:
		

		if common is not None:
			if ptr1.getData() != ptr2.getData():
				common = None
				break
		else:
			if ptr1.getData() == ptr2.getData():
				common = ptr1

		ptr1 = ptr1.getNext()
		ptr2 = ptr2.getNext()

	return common


A = [random.randint(0, 100) for x in range(0, random.randint(1, 10))]
B = [random.randint(0, 100) for x in range(0, random.randint(1, 10))]
C = [random.randint(0, 100) for x in range(0, random.randint(1, 10))]

print(A, B, C)

l1 = create_list(A)
l2 = create_list(B)
l3 = create_list(C)
#print_list(l1)
#print_list(l2)
a1 = append_list(l1, l3)
a2 = append_list(l2, l3)
#print_list(a1)
#print_list(a2)
common_node = find_common_node(a1, a2)
print_list(common_node)


print("hello")
node = Node