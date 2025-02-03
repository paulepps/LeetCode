class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int prevIndex = hashmap.getOrDefault(nums[currentIndex], -1000000);

            if (currentIndex - prevIndex <= k)
                return true;

            hashmap.put(nums[currentIndex], currentIndex);
        }
        return false;
    }
}