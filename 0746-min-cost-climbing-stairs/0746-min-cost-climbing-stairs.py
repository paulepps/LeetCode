from typing import List

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        costMin = [0] * n

        costMin[0] = cost[0]
        costMin[1] = cost[1]

        for i in range(2, n):
            costMin[i] = min(cost[i] + costMin[i - 2], cost[i] + costMin[i - 1])

        return min(costMin[n - 1], costMin[n - 2])
