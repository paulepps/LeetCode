from typing import List

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0

        m, n = len(matrix), len(matrix[0])
        # dp has an extra row and column (initialized to 0) to avoid boundary checks
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        
        max_side = 0

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    dp[i + 1][j + 1] = min(
                        dp[i][j + 1],   # top
                        dp[i + 1][j],   # left
                        dp[i][j]        # top-left
                    ) + 1
                    max_side = max(max_side, dp[i + 1][j + 1])

        return max_side * max_side
