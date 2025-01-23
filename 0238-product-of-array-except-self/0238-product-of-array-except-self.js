/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    const answer = [];
    let curr = 1;

    for (let i = 0; i < nums.length; i++) {
        answer[i] = curr;
        curr *= nums[i];
    }    

    curr = 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        answer[i] *= curr;
        curr *= nums[i];
    }

    return answer;    
};