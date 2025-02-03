class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        String ans = "";
        int i1, i2;
        int len1 = word1.length();
        int len2 = word2.length();
        
        for (i1 = 0, i2 = 0; i1 < len1 && i2 < len2; i1++, i2++) {
            ans += word1.substring(i1, i1 + 1);
            ans += word2.substring(i2, i2 + 1);
        }

        if (i1 == len1) {
            ans += word2.substring(i2);
        } else {
            ans += word1.substring(i1);
        }

        return ans;
    }
}