class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;

        if (n == 1)
            return nums[0];

        int prev = nums[0];
        int secondPrev = 0;

        int loot = 0;
        for (int i = 1; i < n; i++) {
            loot = Math.max(nums[i] + secondPrev, prev);
            secondPrev = prev;
            prev = loot;
        }
        return loot;
    }
}