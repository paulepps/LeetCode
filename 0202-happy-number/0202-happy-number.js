/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    let nums = [];
    while (true)
        {
            n = (n + "").split("").map(Number).reduce((a,b) => a + b * b, 0);
            if (n === 1) return true;
            if (nums.includes(n)) return false;
            nums.push(n);
        }
};