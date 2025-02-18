class Solution {

    private int m;
    private int n;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k) {
        if (k == word.length() - 1) {
            return board[i][j] == word.charAt(k);
        }
        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        char c = board[i][j];
        board[i][j] = '.';

        int dirs[] = {-1, 0, 1, 0, -1};
        for (int d = 0; d < 4; d++) {
            int x = i + dirs[d];
            int y = j + dirs[d + 1];
            
            if (x >= 0 && x < m && y >= 0 && y < n && 
                board[x][y] != '.' && dfs(x, y, k + 1)) {
                    return true;
            }
        }
        board[i][j] = c;
        return false;
    }
}