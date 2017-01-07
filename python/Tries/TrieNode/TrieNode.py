class TrieNode:
    NO_OF_ALPHABETS = 26

    def __init__(self, char):
        self.char = char
        self.children = dict()
        self.words = 0

    def getChar(self):
        return self.char

    def getChildren(self):
        return list(self.children.values())

    def addChar(self, char):
        if char not in self.children:
            newnode = TrieNode(char)
            self.children[char] = newnode
        return self.children[char]

    def addString(self, string):
        if string is None or len(string) < 1:
            return
        firstChar = string[0]
        node = self.addChar(char)
        node.addString(string[1:])

    def noOfWords(self):
        return len(self.children)
