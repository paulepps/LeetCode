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

    findShortestRoot(word: string): string {
        let current = this.root;
        let rootWord = "";

        for (const c of word) {
            if (current.isEndOfWord) {
                return rootWord;
            }
            if (!(c in current.children)) {
                return word;
            }
            rootWord += c;
            current = current.children[c];
        }

        return word;
    }
}

function replaceWords(dictionary: string[], sentence: string): string {
    const trie = new Trie();
    for (const root of dictionary) {
        trie.insert(root);
    }

    const words = sentence.split(" ");
    const result = words.map(word => trie.findShortestRoot(word));
    return result.join(" ");
}
