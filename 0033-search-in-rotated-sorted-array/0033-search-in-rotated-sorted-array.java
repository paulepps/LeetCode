class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {
            return -1;
        }

        int mid = (lo + hi) / 2;

        if (target == nums[mid]) {
            return mid;
        }
    
        if (nums[lo] <= nums[mid]) { // left half is sorted
            if(nums[lo] <= target && target < nums[mid]) {
                return binarySearch(nums, lo, mid-1, target);
            } else {
                return binarySearch(nums, mid+1, hi, target);
            }
        } else { // right half is sortedz
            if(nums[mid] < target && target <= nums[hi]) {
                return binarySearch(nums, mid+1, hi, target);
            } else {
                return binarySearch(nums, lo, mid-1, target);        
            }
        }
    }
}