class Solution {
    public int minDistance(String word1, String word2) {
        return editDistance(word1, word2, word1.length(), word2.length());
    }

    private int editDistance(String s1, String s2, int m, int n) {

        if (m == 0) return n;

        if (n == 0) return m;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return editDistance(s1, s2, m - 1, n - 1);

        int insert = editDistance(s1, s2, m, n - 1);    
        int replace = editDistance(s1, s2, m - 1, n - 1);
        int remove = editDistance(s1, s2, m - 1, n);    

        return 1 + Math.min(insert, Math.min(remove, replace));
    }
}