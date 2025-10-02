class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(); 
        int n = text2.length();
        int[][] memo = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return lcsRec(text1, text2, m, n, memo);
    }

    private int lcsRec(String text1, String text2, int m, int n, int[][] memo) {

        if (m == 0 || n == 0)
            return 0;

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return memo[m][n] = 1 + lcsRec(text1, text2, m - 1, n - 1, memo);
        }
        
        return memo[m][n] = 
            Math.max(lcsRec(text1, text2, m, n - 1, memo), lcsRec(text1, text2, m - 1, n, memo));
    }
}