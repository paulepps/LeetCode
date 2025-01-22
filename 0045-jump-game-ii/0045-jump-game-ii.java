class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
    
        if (nums[0] >= nums.length - 1)
            return 1;
            
        int maxReach = nums[0];
        int step = nums[0];
        int jumps = 1;

        for (int i = 1; i < nums.length; i++)
        {
            if (i == nums.length - 1)
                return jumps;

            if (nums[i] >= (nums.length - 1) - i)
                return jumps + 1;

            maxReach = Math.max(maxReach, i + nums[i]);

            step--;

            if (step == 0)
            {
                jumps++;

                step = maxReach - i;
            }
        }
        return -1;
    }
} 
