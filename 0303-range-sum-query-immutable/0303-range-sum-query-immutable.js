/**
 * @param {number[]} nums
 */
var NumArray = function(nums) {
    this.dpArray = [nums[0]];
    for (let i = 1; i < nums.length; i++)
        {
            this.dpArray[i] = this.dpArray[i-1] + nums[i];
        }
};

/** 
 * @param {number} left 
 * @param {number} right
 * @return {number}
 */
NumArray.prototype.sumRange = function(left, right) {
    let sum = this.dpArray[right];
    return (left === 0) ? sum : sum - this.dpArray[left-1];
};

/** 
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */