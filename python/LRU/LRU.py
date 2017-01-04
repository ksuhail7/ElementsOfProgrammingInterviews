from Node import Node
class LRU:

    def __init__(self, size, datastore=None):
        self.size = size
        self.datastore = datastore
        self.hash = dict()
        self.count = 0
        self.head = None
        self.tail = None

    
    def get(self, key):
    	value = self.reference(key).getValue()
    	self.printList()
    	return value

    def evict(self):
    	evicted = None
    	if self.isEmpty is True:
    		return None
    	if self.tail is not None:
    		evicted = self.tail
    		previous = self.tail.getPrevious()
    		if previous is not None:
    			previous.setNext(None)
    		self.tail = previous
    		evicted.setPrevious(None)
    		evicted.setNext(None)
    		if self.head.getKey() == evicted.getKey():
    			self.head = None
    		del self.hash[evicted.getKey()]
    		#print("Evicted node:" + str(evicted.getKey()) + ", " + evicted.getValue())
    		self.count -= 1
    	return evicted

    def addToHead(self, node):
    	node.setNext(self.head)
    	if self.head is not None:
    		self.head.setPrevious(node)
    	self.head = node
    	if self.tail is None:
    		self.tail = node
    	self.hash[node.getKey()] = node
    	#print("Node added: " + str(node.getKey()) + ", " + node.getValue())
    	return node

    def reference(self, key):
    	if key not in self.hash:
    		if key not in self.datastore:
    			raise KeyError
    		node = Node(key, self.datastore[key])
    		if self.isFull():
    			evicted = self.evict()
    			if self.isFull():
    				return node
    		self.count+=1
    	else:
    		node = self.hash[key]	

    		if self.head.getKey() != node.getKey():
    			found_next = node.getNext()
    			found_previous = node.getPrevious()
    			if found_previous is not None:
    				found_previous.setNext(found_next)
    			if found_next is not None:
    				found_next.setPrevious(found_previous)

    		if self.tail.getKey() == node.getKey():
    			self.tail = node.getPrevious()
    		del self.hash[key]
   
    	return self.addToHead(node)


    def isFull(self):
    	if self.count >= self.size:
    		return True
    	return False

    def isEmpty(self):
    	if self.count == 0:
    		return True
    	return False

    def printList(self):
    	ptr = self.head
    	arr = []
    	while ptr is not None:
    		arr.append(ptr.getKey())
    		ptr = ptr.getNext()
    	print("[" + ",".join(str(x) for x in arr) + "]")





