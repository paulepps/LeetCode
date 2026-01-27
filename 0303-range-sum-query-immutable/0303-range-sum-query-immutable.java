class NumArray {

    private int prefixSums[];

    public NumArray(int[] nums) {
        int n = nums.length;

        prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSums[i] = nums[i] + prefixSums[i - 1];
        }    
    }
    
    public int sumRange(int left, int right) {
        return left == 0 ? prefixSums[right] 
                         : prefixSums[right] - prefixSums[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */