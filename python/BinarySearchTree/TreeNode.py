class TreeNode:
	def __init__(self, data, left=None, right=None):
		self.data = data
		self.left = left
		self.right = right

	def getData(self):
		return self.data

	def getLeft(self):
		return self.left

	def getRight(self):
		return self.right

	def setLeft(self, left):
		self.left = left

	def setRight(self, right):
		self.right = right
	