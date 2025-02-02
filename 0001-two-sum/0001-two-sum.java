class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];

            if (hashmap.containsKey(n)) {
                return new int[] {i, hashmap.get(n)};
            }
            else {
                hashmap.put(nums[i], i);
            }
        }
        return new int[2];
    }
}