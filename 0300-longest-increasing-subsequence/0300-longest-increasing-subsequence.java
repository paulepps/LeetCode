class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int lis[] = new int[n];
      
        for (int i = 0; i < n; i++)
            lis[i] = 1;

        for (int i = 1; i < n; i++)
            for (int prev = 0; prev < i; prev++)
                if (arr[i] > arr[prev] && lis[i] < lis[prev] + 1)
                    lis[i] = lis[prev] + 1;

        int max = 1;
        for (int i = 0; i < n; i++)
            max = Math.max(max, lis[i]);

        return max;
    }
}