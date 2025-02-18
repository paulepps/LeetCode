class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        if (nums[0] <= nums[n - 1]) {
            return nums[0];
        }

        return binarySearch(nums, 0, nums.length - 1);        
    }

    private int binarySearch(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return nums[lo];
        }

        int mid = (lo + hi) / 2;

        if (nums[0] <= nums[mid]) {
            return binarySearch(nums, mid + 1, hi);
        } else {
            return binarySearch(nums, lo, mid);
        }
    }
}
