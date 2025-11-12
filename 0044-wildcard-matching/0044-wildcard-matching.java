class Solution {
    private char[] txtArray;
    private char[] patArray;
    
    private Boolean[][] memo;
    
    private int n;
    private int m;
    
    public boolean isMatch(String s, String p) {
        txtArray = s.toCharArray();
        patArray = p.toCharArray();
        
        n = s.length();
        m = p.length();
        
        memo = new Boolean[n][m];

        return wildCardRecur(0, 0);
    }

    private boolean wildCardRecur(int i, int j) {
        
        // Base case: reached end of string
        if (i >= n) {
            return j >= m || (patArray[j] == '*' && wildCardRecur(i, j + 1));
        }    
        
        // Base case: reached end of pattern but not end of string
        if (j >= m) {
            return false;
        }
        
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        if (patArray[j] == '*') {
            memo[i][j] = wildCardRecur(i + 1, j) || 
                         wildCardRecur(i + 1, j + 1) ||
                         wildCardRecur(i, j + 1);
        } else {
            memo[i][j] = (patArray[j] == '?' || 
                            txtArray[i] == patArray[j]) && 
                                 wildCardRecur(i + 1, j + 1);
        }
      
        return memo[i][j];    
    }
}
