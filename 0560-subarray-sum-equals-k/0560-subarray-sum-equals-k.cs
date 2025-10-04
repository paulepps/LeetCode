public class Solution {
    public int SubarraySum(int[] nums, int k) {
        Dictionary<int, int> prefixSums = new Dictionary<int, int>();
      
        prefixSums.Add(0, 1);
      
        int count = 0;
        int sum = 0;
      
        foreach (int num in nums) {
            sum += num;
          
            int value = 0;
            if (prefixSums.TryGetValue(sum - k, out value)) {
                count += value;
            }
          
            if (prefixSums.TryGetValue(sum, out value)) {
                prefixSums[sum]++;
            } else {
                prefixSums[sum] = 1;
            }
        }
      
        return count;
    }
}

