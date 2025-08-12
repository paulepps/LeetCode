class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (col > 0) {
                    dp[col] += dp[col - 1];
                }
            }
        }
        return dp[n - 1];
    }
}