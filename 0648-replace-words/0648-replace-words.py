from typing import List

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for root in dictionary:
            trie.insert(root)

        words = sentence.split()
        result = [trie.find_shortest_root(word) for word in words]
        return " ".join(result)


class TrieNode:
    def __init__(self):
        self.children = {}  # dictionary: char -> TrieNode
        self.is_end_of_word = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        current = self.root
        for c in word:
            if c not in current.children:
                current.children[c] = TrieNode()
            current = current.children[c]
        current.is_end_of_word = True

    def find_shortest_root(self, word: str) -> str:
        current = self.root
        root_word = ""

        for c in word:
            if current.is_end_of_word:
                return root_word
            if c not in current.children:
                return word
            root_word += c
            current = current.children[c]

        return word
