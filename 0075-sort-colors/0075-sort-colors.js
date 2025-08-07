/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    let pivot = 1;
    let smaller = 0, equal = 0, larger = nums.length;

    while (equal < larger){
        if (nums[equal] < pivot){
            swap(nums,smaller++,equal++);
        }
        else if(nums[equal] == pivot)
            ++equal;
        else
            swap(nums,--larger,equal);
    }
}

const swap = (nums, i, j) => {
    let temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}