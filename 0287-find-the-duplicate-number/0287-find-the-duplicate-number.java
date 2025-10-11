class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int ans = 0;

        for (int shift = 0; shift < 32; shift++) {
            int count = 0;

            // Count set bits in array
            for (int num : nums) {
                count += (num & (1 << shift));
            }

            // Count expected set bits
            for (int i = 1; i <= n; i++) {
                count -= (i & (1 << shift));
            }

            // If difference remains, must be from duplicate number
            if (count > 0)
                ans |= (1 << shift);
        }
        return ans;
    }
}