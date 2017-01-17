from trienode import TrieNode


class Trie:

    def __init__(self):
        self.root = None

    def add_string(self, string):
            self.root = self.add_string_helper(self.root, string + '*', 0)

    def add_string_helper(self, node, string, index):
        if string is None or index >= len(string):
            return None # terminating string or root

        if node is None:
            node = TrieNode('*')

        character = string[index]
        children = node.get_children()
        if character not in node.get_children():
            #print("adding new node", character, "root node", node.get_char())
            children[character] = TrieNode(character)

        new_node = self.add_string_helper(children[character], string, index+1)
        if new_node is not None:
            node.add_children(character, new_node)
        return node

    def get_full_words(self):
        return Trie.get_full_words_helper(self.root)

    @staticmethod
    def get_full_words_helper(node):
        if node is None:
            return []
        children = node.get_children()
        words = []
        if '*' in children:
            words.append(node.get_char())

        substrings = []
        for child in children:
            substrings = Trie.get_full_words_helper(children[child])
            for substr in substrings:
                if node.get_char() is not '*':
                    words.append(node.get_char() + substr)
                else:
                    words.append(substr)
        return words

    def get_matching_words(self, prefix):
        if prefix is None or len(prefix) == 0:
            return self.get_full_words()

        node = self.root
        for char in prefix:
            if node is None:
                return []
            children = node.get_children()
            if char in children:
                node = children[char]
            else:
                node = None

        if node is None:
            return []

        partial_words = []
        words = []
        if node.is_complete_word():
            words.append(prefix)
        children = node.get_children()
        for child in children:
            partial_words.append(Trie.get_full_words_helper(children[child]))

        for partial_word in partial_words:
            for pword in partial_word:
                words.append(prefix + pword)

        return words

