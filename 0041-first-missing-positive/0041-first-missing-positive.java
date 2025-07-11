class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] hash = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0 && num < hash.length) {
                hash[num] = -1;
            }
        }
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] != -1) {
                return i;
            }
        }
        return nums.length + 1;
    }
}