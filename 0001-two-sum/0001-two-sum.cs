public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        // for (int i = 0; i < nums.Length - 1; i++) {
        //     for (int j = i + 1; j < nums.Length; j++) {
        //         if (nums[i] + nums[j] == target) 
        //             return new int[] {i, j};
        //     }
        // }
        for (int i = 0; i < nums.Length - 1; i++) {
            int j = Array.IndexOf(nums, target - nums[i], i+1);
            if (j > -1)
                    return new int[] {i, j};
            }
        
        return new int[] {-1 , -1};
    }
}