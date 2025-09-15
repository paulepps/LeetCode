class Solution {

    int[][] grid;
    int numRows;
    int numCols;
    int size = 0;
    int maxSize = 0;

    public int maxAreaOfIsland(int[][] grid) {

        this.grid = grid;
        numRows = this.grid.length;
        numCols = this.grid[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (this.grid[i][j] == 1) {
                    size = 0;
                    dfs(i, j);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    private void dfs(int row, int col) {
        if (row < 0 || row == numRows ||
            col < 0 || col == numCols)
            return;
        if (grid[row][col] != 1) 
            return;

        grid[row][col] = 0;
        size++;

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}