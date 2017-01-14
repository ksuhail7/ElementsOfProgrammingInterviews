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


def length(head):
	sz = 0
	ptr = head
	while ptr is not None:
		ptr = ptr.getNext()
		sz+=1
	return sz

def delete_kth_last_element(head, k):
	ptr1 = head
	ptr2 = head
	while k > 0 and ptr2 is not None and ptr2.getNext() is not None:
		ptr2 = ptr2.getNext()
		k-=1

	if k > 0:
		return None

	ptr0 = None
	while ptr2 is not None:
		ptr2 = ptr2.getNext()
		if ptr0 is None:
			ptr0 = ptr1
		else:
			ptr0 = ptr0.getNext()

		ptr1 = ptr1.getNext()

	if ptr1 is not None:
		ptr0.setNext(ptr1.getNext())

	return head


l1 = [random.randint(0, 100) for x in range(0, 10)]
list1 = create_list(l1)

print_list(list1)

k = 3
new_head = delete_kth_last_element(list1, k)
print_list(new_head)


