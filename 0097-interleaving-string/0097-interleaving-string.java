class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[] prev = new boolean[n + 1];
        boolean[] curr = new boolean[n + 1];

        prev[0] = true;

        // Fill the first column (interleaving s2 with an empty s1)
        for (int j = 1; j <= n; j++) {
            prev[j] = prev[j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }

        // Fill the rest of the DP table
        for (int i = 1; i <= m; i++) {

            curr[0] = prev[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));

            for (int j = 1; j <= n; j++) {
                int k = i + j;
                curr[j] = (prev[j] && (s1.charAt(i - 1) == s3.charAt(k - 1))) ||
                           (curr[j - 1] && (s2.charAt(j - 1) == s3.charAt(k - 1)));
            }

            prev = curr.clone();
        }

        return prev[n];
    }
}