class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums)
            {
                sum += num;
            }
        int n = nums.length;
        return (n * (n+1) / 2) - sum;

        // for (int i = 0; i <= nums.length; ++i) {
        //     sum ^= i;
        // } 
        // for (int i = 0; i < nums.length; ++i) {
        //     sum ^= nums[i];
        // } 
        // return sum;
    }
}