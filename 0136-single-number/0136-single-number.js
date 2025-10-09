/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let result = 0;
    for (const num of nums) {
        result ^= num; // XOR cancels out duplicates
    }
    return result;
}
