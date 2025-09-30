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

    def search(self, word: str) -> bool:
        return self._search(word, self.root)

    def _search(self, word: str, node: TrieNode) -> bool:
        for i, c in enumerate(word):
            if c == '.':
                for child in node.children.values():
                    if self._search(word[i + 1:], child):
                        return True
                return False
            else:
                if c not in node.children:
                    return False
                node = node.children[c]
        return node.is_end_of_word

    def starts_with(self, prefix: str) -> bool:
        current = self.root
        for c in prefix:
            if c not in current.children:
                return False
            current = current.children[c]
        return True


class WordDictionary:
    def __init__(self):
        self.trie = Trie()

    def addWord(self, word: str) -> None:
        self.trie.insert(word)

    def search(self, word: str) -> bool:
        return self.trie.search(word)
