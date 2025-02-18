/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
        
    let sum = 0;
    for (let num of nums) {
        sum ^= num;
    }
    return sum;
};
