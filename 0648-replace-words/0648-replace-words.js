class TrieNode {
    constructor() {
        this.children = {};
        this.isEndOfWord = false;
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode();
    }

    insert(word) {
        let current = this.root;
        for (const c of word) {
            if (!(c in current.children)) {
                current.children[c] = new TrieNode();
            }
            current = current.children[c];
        }
        current.isEndOfWord = true;
    }

    findShortestRoot(word) {
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

/**
 * @param {string[]} dictionary
 * @param {string} sentence
 * @return {string}
 */
var replaceWords = function(dictionary, sentence) {
    
    const trie = new Trie();
    for (const root of dictionary) {
        trie.insert(root);
    }

    const words = sentence.split(" ");
    const result = words.map(word => trie.findShortestRoot(word));
    return result.join(" ");
};