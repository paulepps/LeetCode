public class Solution {
    
    int ROW, COL;
    
    public int NumIslands(char[][] grid) {
        
        ROW = grid.Length;
        if (ROW == 0) return 0;
        COL = grid[0].Length;
        
        bool[, ] visited = new bool[ROW, COL]; 
  
        int count = 0; 
        
        for (int i = 0; i < ROW; i++) 
            for (int j = 0; j < COL; j++) 
                if (grid[i][j] == '1' && !visited[i, j]) { 
                    DFS(grid, i, j, visited); 
                    ++count; 
                } 
  
        return count; 
    }

    bool isSafe(char[][] grid, int row, 
                       int col, bool[, ] visited) 
    { 
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (grid[row][col] == '1' && !visited[row, col]); 
    } 
  
    void DFS(char[][] grid, int row, 
                    int col, bool[, ] visited) 
    { 
        int[] rowNbr = new int[] { -1, 0, 0, 1 }; 
        int[] colNbr = new int[] { 0, -1, 1, 0 }; 
  
        visited[row, col] = true; 
  
        for (int k = 0; k < 4; k++) 
            if (isSafe(grid, row + rowNbr[k], col + colNbr[k], visited)) 
                DFS(grid, row + rowNbr[k], 
                    col + colNbr[k], visited); 
    } 
  
}