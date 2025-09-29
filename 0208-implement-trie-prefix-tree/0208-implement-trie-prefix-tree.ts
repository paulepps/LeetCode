class TrieNode {
    children: Map<string, TrieNode>;
    isEndOfWord: boolean;

    constructor() {
        this.children = new Map<string, TrieNode>();
        this.isEndOfWord = false;
    }
}

class Trie {
    private root: TrieNode;

    constructor() {
        this.root = new TrieNode();
    }

    insert(word: string): void {
        let current = this.root;
        for (const c of word) {
            if (!current.children.has(c)) {
                current.children.set(c, new TrieNode());
            }
            current = current.children.get(c)!;
        }
        current.isEndOfWord = true;
    }

    search(word: string): boolean {
        let current = this.root;
        for (const c of word) {
            if (!current.children.has(c)) {
                return false;
            }
            current = current.children.get(c)!;
        }
        return current.isEndOfWord;
    }

    startsWith(prefix: string): boolean {
        let current = this.root;
        for (const c of prefix) {
            if (!current.children.has(c)) {
                return false;
            }
            current = current.children.get(c)!;
        }
        return true;
    }
}
