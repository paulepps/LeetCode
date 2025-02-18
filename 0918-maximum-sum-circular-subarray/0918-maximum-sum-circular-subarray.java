class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       
        int localMax = nums[0];
        int localMin = nums[0];
        int globalMax = nums[0];
        int globalMin = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            if (localMax > globalMax) {
                globalMax = localMax;
            }

            localMin = Math.min(nums[i], localMin + nums[i]);
            if (localMin < globalMin) {
                globalMin = localMin;
            }

            totalSum += nums[i];
        }

        int normalSum = globalMax;
        int circularSum = totalSum - globalMin;

        if (globalMin == totalSum) {
            return normalSum;
        }

        return Math.max(normalSum, circularSum);
    }
}