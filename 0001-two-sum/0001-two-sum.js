/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {

    const map = new Map();

    for (let i = 0; i < nums.length; i++) {
        let n = target - nums[i];

        if (map.has(n)) {
            return [i, map.get(n)];
        }
        else {
            map.set(nums[i], i);
        }
    }
};