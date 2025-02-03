public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<Int32, Int32> map = new Dictionary<Int32, Int32>();

        for (int i = 0; i < nums.Length; i++) {
            int n = target - nums[i];

            if (map.ContainsKey(n)) {
                return new int[]{i, map[n]};
            }
            else {
                map.Add(nums[i], i);
            }
        }
        // shouldn't get here
        return new int[2];

    }
}