class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        if (len == 0 || len == 1) {
            return len;
        }

        int maxLength = 0;
        boolean[] visited = new boolean[256];

        int left = 0;
        int right = 0;

        while (right < len) {
            if (visited[s.charAt(right)]) {
                while (visited[s.charAt(right)]) {
                    visited[s.charAt(left)] = false;
                    left++;
                }
            }

            visited[s.charAt(right)] = true;

            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        } 
        return maxLength;
    }
}