#!/usr/bin/env python3

from trie import Trie

trie = Trie()

trie.add_string("hello")
trie.add_string("happy")
trie.add_string("cat")
trie.add_string("chunnu")
trie.add_string("call")

#words = trie.get_node("h")
print(trie.get_matching_words("h"))

print(trie.get_full_words())

