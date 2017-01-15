class TrieNode:

    def __init__(self, character):
        self.character = character
        self.children = dict()
        self.no_of_words = 0

    def get_char(self):
        return self.character

    def get_word_count(self):
        return self.no_of_words

    def get_children(self):
        return self.children

    def add_children(self, ch, node):
        self.children[ch] = node

    def is_complete_word(self):
        if '*' in self.children:
            return True
        return False

    def get_complete_words(self):
        words = []
        for child in list(self.children.values()):
            words.append()