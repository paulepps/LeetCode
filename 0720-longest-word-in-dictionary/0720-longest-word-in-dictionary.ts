class TrieNode {
    children: { [key: string]: TrieNode };
    isEndOfWord: boolean;

    constructor() {
        this.children = {};   // plain object instead of Map
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

    canBuild(word: string): boolean {
        let current = this.root;
        for (const c of word) {
            if (!(c in current.children)) {
                return false;
            }
            current = current.children[c];
            if (!current.isEndOfWord) {
                return false;
            }
        }
        return true;
    }
}

function longestWord(words: string[]): string {
    const trie = new Trie();
    for (const word of words) {
        trie.insert(word);
    }

    let answer = "";
    for (const word of words) {
        if (trie.canBuild(word)) {
            if (
                word.length > answer.length ||
                (word.length === answer.length && word < answer)
            ) {
                answer = word;
            }
        }
    }
    return answer;
}
