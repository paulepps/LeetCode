class TrieNode {
    TrieNode[] children;
    int ref;

    public TrieNode() {
        children = new TrieNode[26];
        ref = -1;
    }
}
class Trie {

    public TrieNode root;

    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word, int ref) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.ref = ref;
    }
}

class Solution {
    private char[][] board;
    private String[] words;
    private List<String> foundWords = new ArrayList<>();
    private int rowCount, colCount;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }

        rowCount = board.length;
        colCount = board[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                dfs(trie.root, i, j);
            }
        }
        return foundWords;
    }

    private void dfs(TrieNode node, int i, int j) {
        int index = board[i][j] - 'a';

        if (node.children[index] == null) {
            return;
        }

        node = node.children[index];

        if (node.ref != -1) {
            foundWords.add(words[node.ref]);
            node.ref = -1;
        }

        char tempChar = board[i][j];
        board[i][j] = '#';

        int[] directions = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int newRow = i + directions[k];
            int newCol = j + directions[k + 1];

            if (newRow >= 0 && newRow < rowCount &&
                    newCol >= 0 && newCol < colCount &&
                    board[newRow][newCol] != '#') {
                dfs(node, newRow, newCol);
            }
        }
        board[i][j] = tempChar;
    }
}