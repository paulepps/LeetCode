class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int result = 1;

        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        for (int i = 1; i < n; i++) {
            result = Math.max(result, lisEndingAtI(nums, i, memo));
        }
        return result;
    }

    private int lisEndingAtI(int[] arr, int idx, int[] memo) {
        if (idx == 0) 
            return 1;

        if (memo[idx] != -1) {
            return memo[idx];
        }

        int max = 1;

        for (int prev = 0; prev < idx; prev++) {
            if (arr[prev] < arr[idx]) {
                max = Math.max(max, lisEndingAtI(arr, prev, memo) + 1);
            }
        }
        memo[idx] = max;
        return max;
    }
}