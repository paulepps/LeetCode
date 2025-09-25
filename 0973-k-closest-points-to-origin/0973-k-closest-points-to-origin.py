import heapq
from typing import List

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # Min-heap storing (distance, index)
        heap = []
        for i, (x, y) in enumerate(points):
            dist = x * x + y * y
            heapq.heappush(heap, (dist, i))

        result = []
        for _ in range(k):
            _, idx = heapq.heappop(heap)
            result.append(points[idx])

        return result
