from TrieNode import TrieNode


class Trie:
    def __init__(self):
        self.root = TrieNode('*')

    def addString(self, string):
        if string is None or len(string) == 0:
            return
        char = string[0]
        start = self.root
