class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int i = 0;

        for (int j = 1; j < nums.length; j++)
        {
            if (nums[i] == nums[j])
            {
                if (count < 2)
                {
                    count++;
                    i++;
                    nums[i] = nums[j];
                }
            } else {
                count = 1;
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}