class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // Calculate mid to avoid potential integer overflow for very large arrays
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid; // Target found, return index
            } else if (nums[mid] < target) {
                start = mid + 1; // Target is in the right half
            } else {
                end = mid - 1; // Target is in the left half
            }
        }

        return -1; // Target not found
    }
}
