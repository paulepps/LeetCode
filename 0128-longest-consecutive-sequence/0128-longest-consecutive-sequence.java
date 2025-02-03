class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> s = new HashSet<>();
        int res = 0;

        for (int i : nums) {
            s.add(i);
        }

        for (int i : nums) {
            if (!s.contains(i - 1)) {
                int j = i;
                while (s.contains(j)) {
                    j++;
                }

                res = Math.max(res, j - i);
            }
        }
        return res;
    }
}