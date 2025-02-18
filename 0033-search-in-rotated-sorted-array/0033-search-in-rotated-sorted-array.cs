public class Solution {
    public int Search(int[] nums, int target) {
        return BinarySearch(nums, 0, nums.Length-1, target);
    }
 
    public int BinarySearch(int[] nums, int left, int right, int target){
        if (left > right) 
            return -1;

        int mid = left + (right-left)/2;

        if (target == nums[mid])
            return mid;

        if (nums[left] <= nums[mid]){
            if (nums[left] <= target && target < nums[mid]){
              return BinarySearch(nums, left, mid-1, target);
            } else {
              return BinarySearch(nums, mid+1, right, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[right]){
              return BinarySearch(nums, mid+1, right, target);
            } else {
              return BinarySearch(nums, left, mid-1, target);
            }
        }
    }
}