class Solution {

    private int [] nums;
    private int target;
    private int totalSum;
    private int[][] dp;
    private int n;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;    

        n = nums.length;

        totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        dp = new int [n][2 * totalSum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findTotalWays(0, 0);
    }

    private int findTotalWays(int i, int sum) {
        
        if (sum == target && i == n) {
            return 1;
        }

        if (i >= n) {
            return 0;
        }

        if (dp[i][sum + totalSum] != -1) {
            return dp[i][sum + totalSum];
        }

        return dp[i][sum + totalSum]
             = findTotalWays(i + 1, sum + nums[i])
             + findTotalWays(i + 1, sum - nums[i]);
    }
}