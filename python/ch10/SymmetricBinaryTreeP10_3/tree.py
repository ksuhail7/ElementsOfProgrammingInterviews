from node import TreeNode


class BinaryTree:
    def __init__(self, array=[]):
        self.array = array
        self.root = None
        self.build_tree()

    def build_tree(self):
        for i in range(0, len(self.array)):
            self.root = self.add_node(self.root, self.array[i], i)

    def add_node(self, node, data, index):
        if data == -1:
            return node

        if node is None:
            return TreeNode(data)

        if index % 2 == 1:
            node.set_left(self.add_node(node.get_left(), data, index))
        else:
            node.set_right(self.add_node(node.get_right(), data, index))

        return node

    def inorder_traversal(self):
        self.inorder_traversal_helper(self.root)

    def inorder_traversal_helper(self, node):
        if node is None:
            return

        self.inorder_traversal_helper(node.get_left())
        print(node.get_data())
        self.inorder_traversal_helper(node.get_right())

    def is_symmetric(self):
        if self.root is None:
            return True
        return self.is_symmetric_helper(self.root.get_left(), self.root.get_right())

    def is_symmetric_helper(self, node1, node2):
        if node1 is None and node2 is None:
            return True

        if node1 is not None and node2 is not None:
            if node1.get_data() == node2.get_data():
                return self.is_symmetric_helper(node1.get_left(), node2.get_right()) and self.is_symmetric_helper(
                    node1.get_right(), node2.get_left())
        return False
