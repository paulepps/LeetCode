class TrieNode {
    children: { [key: string]: TrieNode };
    isEndOfWord: boolean;
    sum: number;

    constructor() {
        this.children = {};
        this.isEndOfWord = false;
        this.sum = 0;
    }
}

class Trie {
    root: TrieNode;

    constructor() {
        this.root = new TrieNode();
    }

    insert(word: string, val: number): void {
        let current = this.root;
        for (const c of word) {
            if (!(c in current.children)) {
                current.children[c] = new TrieNode();
            }
            current = current.children[c];
            current.sum += val;
        }
        current.isEndOfWord = true;
    }

    startsWith(prefix: string): number {
        let current = this.root;
        for (const c of prefix) {
            if (!(c in current.children)) {
                return 0;
            }
            current = current.children[c];
        }
        return current.sum;
    }
}

class MapSum {
    private map: { [key: string]: number };
    private trie: Trie;

    constructor() {
        this.map = {};
        this.trie = new Trie();
    }

    insert(key: string, val: number): void {
        const currVal = this.map[key] ?? 0;
        this.map[key] = val;
        this.trie.insert(key, val - currVal);
    }

    sum(prefix: string): number {
        return this.trie.startsWith(prefix);
    }
}
