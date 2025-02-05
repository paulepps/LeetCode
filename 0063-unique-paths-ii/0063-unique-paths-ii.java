class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int numRows = obstacleGrid.length;
        int numCols = obstacleGrid[0].length;

        int[] dp = new int[numCols];
        dp[0] = 1;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[col] = 0;
                } else if (col > 0) {
                    dp[col] += dp[col - 1];
                }
            }
        }
        return dp[numCols - 1];
    }
}