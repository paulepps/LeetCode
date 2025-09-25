import heapq
from typing import List

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # nlargest returns the k largest elements in descending order
        return heapq.nlargest(k, nums)[-1]
