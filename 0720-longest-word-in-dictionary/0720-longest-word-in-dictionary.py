from typing import List

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

    def can_build(self, word: str) -> bool:
        """
        Check if this word can be built one character at a time
        with all prefixes present in the Trie.
        """
        current = self.root
        for c in word:
            if c not in current.children:
                return False
            current = current.children[c]
            if not current.is_end_of_word:
                return False
        return True


class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)

        answer = ""
        for word in words:
            if trie.can_build(word):
                if len(word) > len(answer) or (len(word) == len(answer) and word < answer):
                    answer = word
        return answer
