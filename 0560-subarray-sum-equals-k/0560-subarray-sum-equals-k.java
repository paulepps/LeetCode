class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
      
        prefixSums.put(0, 1);
      
        int count = 0;
        int sum = 0;
      
        for (int num : nums) {
            sum += num;
          
            count += prefixSums.getOrDefault(sum - k, 0);
          
            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }
      
        return count;

    }
}