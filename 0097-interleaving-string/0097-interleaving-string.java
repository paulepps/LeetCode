class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s1.length() + s2.length() != s3.length())
            return false;

        return isInterleaveRec(s1, s2, s3, 0, 0);
    }

    private boolean isInterleaveRec(String s1, String s2, String s3, int i, int j) {
        
        int k = i + j;
      
        if (i == s1.length() && j == s2.length() && k == s3.length()) 
            return true;    
    
        boolean b1 = (i < s1.length()) && (s3.charAt(k) == s1.charAt(i)) && 
                   isInterleaveRec(s1, s2, s3, i + 1, j);
        boolean b2 = (j < s2.length()) && (s3.charAt(k) == s2.charAt(j)) && 
                   isInterleaveRec(s1, s2, s3, i, j + 1);
        
        return b1 || b2;
    }
}