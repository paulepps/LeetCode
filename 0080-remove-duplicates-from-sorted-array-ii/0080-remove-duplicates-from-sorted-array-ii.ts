function removeDuplicates(nums: number[]): number {
    let count: number = 1;
    let i: number = 0;

    for (let j: number = 1; j < nums.length; j++)
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
};
