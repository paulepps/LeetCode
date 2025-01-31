class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int result = 1;

        for (int i = 1; i < n; i++) {
            result = Math.max(result, lisEndingAtI(nums, i));
        }
        return result;
    }

    private int lisEndingAtI(int[] arr, int idx) {
        if (idx == 0) 
            return 1;

        int max = 1;

        for (int prev = 0; prev < idx; prev++) {
            if (arr[prev] < arr[idx]) {
                max = Math.max(max, lisEndingAtI(arr, prev) + 1);
            }
        }
        return max;
    }
}