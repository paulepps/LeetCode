function findTargetSumWays(nums: number[], target: number): number {

    const n: number = nums.length;

    const totalSum: number = nums.reduce((a, b) => a + b, 0);

    // Initialize dp with -1
    const dp: number[][] = Array.from({ length: n }, 
                                () => new Array(2 * totalSum + 1).fill(-1));

    function findTotalWays(i: number, currSum: number): number {
        if (currSum === target && i === n) {
            return 1;
        }

        if (i >= n) {
            return 0;
        }

        if (dp[i][currSum + totalSum] !== -1) {
            return dp[i][currSum + totalSum];
        }

        const add = findTotalWays(i + 1, currSum + nums[i]);
        const subtract = findTotalWays(i + 1, currSum - nums[i]);

        dp[i][currSum + totalSum] = add + subtract;
        return dp[i][currSum + totalSum];
    }

    return findTotalWays(0, 0);
}
