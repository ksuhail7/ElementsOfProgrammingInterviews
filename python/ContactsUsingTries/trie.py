from trienode import TrieNode


class Trie:

    def __init__(self):
        self.root = None

    def add_string(self, string):
        for i in range(0, len(string)+1):
            if i < len(string):
                character = string[i]
            else:
                character = '*'
            self.root = self.add_string_helper(self.root, character)

    def add_string_helper(self, node, character):
        if node is None:
            return TrieNode('*') # terminating string or root
        children = node.get_children()
        if character in children:
            new_node = self.add_string_helper(children[character], character)
        else:
            new_node = TrieNode(character)
        node.add_children(character, new_node)
        return node

    def get_node(self, prefix):
        node = self.root
        for i in range(0, len(prefix)):
            if node is not None:
                node = self.get_node_helper(node, prefix[i])
            else:
                print("no such word found")
                break

    @staticmethod
    def get_node_helper(node, character):
        if node is not None:
            children = node.get_children()
            if character in children:
                return children[character]

        return None

    def get_word_count(self, prefix):
        pass
