class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        if (n == 1)
            return strs[0];

        Arrays.sort(strs);

        int min = Math.min(strs[0].length(), strs[n-1].length());

        int i = 0;
        while (i < min && strs[0].charAt(i) == strs[n-1].charAt(i))
            i++;

        String prefix = strs[0].substring(0, i);
        return prefix;
    }
}