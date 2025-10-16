class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int maxProduct = 0;
            for (int j = 1; j < i; j++) {
                maxProduct = Math.max(maxProduct, 
                                Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = maxProduct;
        }
        return dp[n];    
    }
}