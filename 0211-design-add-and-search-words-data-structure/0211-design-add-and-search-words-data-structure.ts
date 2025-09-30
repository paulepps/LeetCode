class TrieNode {
    children: { [key: string]: TrieNode };
    isEndOfWord: boolean;

    constructor() {
        this.children = {};
        this.isEndOfWord = false;
    }
}

class Trie {
    root: TrieNode;

    constructor() {
        this.root = new TrieNode();
    }

    insert(word: string): void {
        let current = this.root;
        for (const c of word) {
            if (!(c in current.children)) {
                current.children[c] = new TrieNode();
            }
            current = current.children[c];
        }
        current.isEndOfWord = true;
    }

    search(word: string): boolean {
        return this._search(word, this.root);
    }

    private _search(word: string, node: TrieNode): boolean {
        for (let i = 0; i < word.length; i++) {
            const c = word[i];
            if (c === ".") {
                for (const child of Object.values(node.children)) {
                    if (this._search(word.slice(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!(c in node.children)) {
                    return false;
                }
                node = node.children[c];
            }
        }
        return node.isEndOfWord;
    }

    startsWith(prefix: string): boolean {
        let current = this.root;
        for (const c of prefix) {
            if (!(c in current.children)) {
                return false;
            }
            current = current.children[c];
        }
        return true;
    }
}

class WordDictionary {
    private trie: Trie;

    constructor() {
        this.trie = new Trie();
    }

    addWord(word: string): void {
        this.trie.insert(word);
    }

    search(word: string): boolean {
        return this.trie.search(word);
    }
}
