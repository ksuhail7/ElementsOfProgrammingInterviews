from treenode import TreeNode


class BinarySearchTree:
    def __init__(self):
        self.init = 1
        self.root = None

    def add(self, element):
        self.root = self.addHelper(self.root, element)
        return self.root

    def addHelper(self, root, element):
        if root is None:
            node = TreeNode(element)
            return node

        if root.getData() >= element:
            root.setLeft(self.addHelper(root.getLeft(), element))
        else:
            root.setRight(self.addHelper(root.getRight(), element))

        return root

    def find(self, element):
        return self.findHelper(self.root, element)

    def findHelper(self, root, element):
        if root is None:
            return None

        if root.getData() == element:
            return root
        elif root.getData() > element:
            return self.findHelper(root.getLeft(), element)
        else:
            return self.findHelper(root.getRight(), element)

    def keyLargerThanK(self, k):
        return self.keyLargerThanKHelper(self.root, k)

    def keyLargerThanKHelper(self, root, k):
        if root is None:
            return None

        if root.getData() <= k:
            node = self.keyLargerThanKHelper(root.getRight(), k)
            if node is None or node.getData() == k:
                return None
            return node
        else:
            node = self.keyLargerThanKHelper(root.getLeft(), k)
            if node is None:
                return root
            return node
