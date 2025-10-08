from typing import List

class Solution:
    def __init__(self):
        self.nums: List[int] = []
        self.target: int = 0
        self.totalSum: int = 0
        self.dp: List[List[int]] = []
        self.n: int = 0

    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        self.nums = nums
        self.target = target
        self.n = len(nums)

        self.totalSum = sum(nums)

        # Initialize dp with -1
        self.dp = [[-1] * (2 * self.totalSum + 1) for _ in range(self.n)]

        return self._findTotalWays(0, 0)

    def _findTotalWays(self, i: int, curr_sum: int) -> int:
        if curr_sum == self.target and i == self.n:
            return 1

        if i >= self.n:
            return 0

        if self.dp[i][curr_sum + self.totalSum] != -1:
            return self.dp[i][curr_sum + self.totalSum]

        add = self._findTotalWays(i + 1, curr_sum + self.nums[i])
        subtract = self._findTotalWays(i + 1, curr_sum - self.nums[i])

        self.dp[i][curr_sum + self.totalSum] = add + subtract
        return self.dp[i][curr_sum + self.totalSum]
