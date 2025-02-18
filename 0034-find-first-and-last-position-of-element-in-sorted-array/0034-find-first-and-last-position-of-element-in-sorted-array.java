class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start = first(nums, 0, nums.length - 1, target);

        if (start == -1) {
            return new int[]{-1, -1};
        }

        int end = last(nums, 0, nums.length - 1, target);
    
        return new int[]{start, end};
    }

    private int first(int[] arr, int lo, int hi, int target) {
        System.out.println(lo + " " + hi);
        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;

            if ((mid == 0 || target > arr[mid - 1])
                    && arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                return first(arr, mid + 1, hi, target);
            } else {
                return first(arr, lo, mid - 1, target);
            }
        } 
        return -1;
    }

    private int last(int[] arr, int lo, int hi, int target) {
        
        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;

            if ((mid == arr.length - 1 || target < arr[mid + 1])
                    && arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                return last(arr, lo, mid - 1, target);
            } else {
                return last(arr, mid + 1, hi, target);
            }
        } 
        return -1;
    }
}