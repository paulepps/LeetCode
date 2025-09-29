from typing import Dict

class TrieNode:
    def __init__(self):
        self.children: Dict[str, 'TrieNode'] = {}
        self.is_end_of_word = False
        self.sum = 0


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str, val: int) -> None:
        current = self.root
        for c in word:
            if c not in current.children:
                current.children[c] = TrieNode()
            current = current.children[c]
            current.sum += val
        current.is_end_of_word = True

    def starts_with(self, prefix: str) -> int:
        current = self.root
        for c in prefix:
            if c not in current.children:
                return 0
            current = current.children[c]
        return current.sum


class MapSum:
    def __init__(self):
        self.map: Dict[str, int] = {}
        self.trie = Trie()

    def insert(self, key: str, val: int) -> None:
        curr_val = self.map.get(key, 0)
        self.map[key] = val
        self.trie.insert(key, val - curr_val)

    def sum(self, prefix: str) -> int:
        return self.trie.starts_with(prefix)
