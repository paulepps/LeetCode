class Solution:
    def climbStairs(self, n: int) -> int:
        prev, curr = 1, 1

        for _ in range(1, n):
            next = prev + curr
            prev, curr = curr, next

        return curr
