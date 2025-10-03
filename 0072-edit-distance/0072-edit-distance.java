class Solution {

    String s1;
    String s2;
    int[][] memo;

    public int minDistance(String word1, String word2) {

        s1 = word1;
        s2 = word2;

        int m = word1.length();
        int n = word2.length();
        
        memo = new int[m + 1][n + 1];
        
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return editDistance(m, n);
    }

    private int editDistance(int m, int n) {

        if (m == 0) return n;

        if (n == 0) return m;

        if (memo[m][n] != -1) return memo[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memo[m][n] = editDistance(m - 1, n - 1);
        } else {
            int insert = editDistance(m, n - 1);    
            int replace = editDistance(m - 1, n - 1);
            int remove = editDistance(m - 1, n);    
            memo[m][n] = 1 + Math.min(insert, Math.min(remove, replace));
        }
        return memo[m][n];
    }
}