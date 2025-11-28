class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE / 2);
        minPrefix[k - 1] = 0;
        
        long sum = 0;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int remainder = i % k;
            max = Math.max(max, sum - minPrefix[remainder]);
            minPrefix[remainder] = Math.min(minPrefix[remainder], sum);
        }
       
        return max;
    }
}