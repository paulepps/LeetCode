class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int numRows = obstacleGrid.length;
        int numCols = obstacleGrid[0].length;

        int[][] dp = new int[numRows][numCols];

        for (int row = 0; row < numRows && obstacleGrid[row][0] == 0; row++) {
            dp[row][0] = 1;
        }

        for (int col = 0; col < numCols && obstacleGrid[0][col] == 0; col++) {
            dp[0][col] = 1;
        }

        for (int row = 1; row < numRows; row++) {
            for (int col = 1; col < numCols; col++) {
                if (obstacleGrid[row][col] == 0) {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }
        return dp[numRows - 1][numCols - 1];
    }
}