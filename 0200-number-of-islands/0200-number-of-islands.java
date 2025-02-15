class Solution {
    char[][] grid;
    int numRows;
    int numCols;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        numRows = this.grid.length;
        numCols = this.grid[0].length;

        int islands = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (this.grid[i][j] == '1') {
                    dfs(i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(int row, int col) {
        if (row < 0 || row == numRows ||
            col < 0 || col == numCols)
            return;
        if (grid[row][col] != '1') 
            return;

        grid[row][col] = '0';

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}