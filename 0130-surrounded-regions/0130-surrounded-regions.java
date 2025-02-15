class Solution {
    char[][] board;
    int numRows;
    int numCols;


    public void solve(char[][] board) {
        this.board = board;
        numRows = board.length;
        numCols = board[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if ((i == 0 || i == numRows - 1 ||
                    j == 0 || j == numCols - 1) &&
                    board[i][j] == 'O') {
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                } 
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col) {
        if (row < 0 || row == numRows ||
            col < 0 || col == numCols)
            return;
        if (board[row][col] != 'O') 
            return;

        board[row][col] = '.';

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }

}