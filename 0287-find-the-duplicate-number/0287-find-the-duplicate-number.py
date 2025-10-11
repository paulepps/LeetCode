from typing import List

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        n = len(nums) - 1
        ans = 0

        for shift in range(32):
            count = 0

            # Count set bits in array
            for num in nums:
                count += (num & (1 << shift))

            # Subtract expected set bits from 1..n
            for i in range(1, n + 1):
                count -= (i & (1 << shift))

            # If difference remains, it must come from the duplicate number
            if count > 0:
                ans |= (1 << shift)

        return ans
