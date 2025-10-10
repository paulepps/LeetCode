function missingNumber(nums: number[]): number {
    let result = 0;

    // XOR all indices from 0 to nums.length
    for (let i = 0; i <= nums.length; i++) {
        result ^= i;
    }

    // XOR all numbers in the array
    for (const num of nums) {
        result ^= num;
    }

    return result;
}
