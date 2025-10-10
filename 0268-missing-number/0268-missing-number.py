from typing import List

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        result = 0

        # XOR all indices from 0 to len(nums)
        for i in range(len(nums) + 1):
            result ^= i

        # XOR all numbers in the array
        for num in nums:
            result ^= num

        return result
