class MapSum {

    private Map<String, Integer> map;
    private Trie trie;
    
    public MapSum() {
        map = new HashMap<>();
        trie = new Trie();        
    }
    
    public void insert(String key, int val) {
        int currVal = map.getOrDefault(key, 0);
        map.put(key, val);
        trie.insert(key, val - currVal);
    }
    
    public int sum(String prefix) {
        return trie.startsWith(prefix);
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int sum;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        sum = 0;
    }
}
class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word, int val) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }

            current.children[c - 'a'].sum += val;

            current = current.children[c - 'a'];
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.isEndOfWord;
    }
    
    public int startsWith(String prefix) {
        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return 0;
            }
            current = current.children[c - 'a'];
        }
        return current.sum;
    }
}