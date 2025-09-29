class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null || !current.children[c - 'a'].isEndOfWord) {
                return false;
            }
            current = current.children[idx];
        }
        return current.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }
        return true;
    }
}

class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
      
        String answer = "";
      
        for (String word : words) {
            if (trie.search(word)) {
                if (answer.length() < word.length() || 
                    (answer.length() == word.length() && word.compareTo(answer) < 0)) {
                    answer = word;
                }
            }
        }
      
        return answer;
    }
}