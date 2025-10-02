from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return nums[0]

        prev = nums[0]
        second_prev = 0

        loot = 0
        for i in range(1, n):
            loot = max(nums[i] + second_prev, prev)
            second_prev = prev
            prev = loot

        return loot
