class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s1.length() + s2.length() != s3.length())
            return false;

        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return isInterleaveRec(s1, s2, s3, 0, 0, memo);
    }

    private boolean isInterleaveRec(String s1, String s2, String s3, int i, int j, int[][] memo) {
        
        int k = i + j;
      
        if (i == s1.length() && j == s2.length() && k == s3.length()) 
            return true;    

        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean b1 = false;
        if (i < s1.length() && s3.charAt(k) == s1.charAt(i))
            b1 = isInterleaveRec(s1, s2, s3, i + 1, j, memo);

        boolean b2 = false;
        if (j < s2.length() && s3.charAt(k) == s2.charAt(j))
            b2 = isInterleaveRec(s1, s2, s3, i, j + 1, memo);
        
        memo[i][j] = b1 || b2 ? 1 : 0;
        return b1 || b2;
    }
}