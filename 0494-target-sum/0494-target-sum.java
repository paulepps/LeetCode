class Solution {

    private int [] nums;
    private int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;    

        return findTotalWays(0, 0);
    }

    private int findTotalWays(int i, int sum) {
        
        if (sum == target && i == nums.length) {
            return 1;
        }

        if (i >= nums.length) {
            return 0;
        }

        return findTotalWays(i + 1, sum + nums[i])
             + findTotalWays(i + 1, sum - nums[i]);
    }
}