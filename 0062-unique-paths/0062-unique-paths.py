class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [0] * n
        dp[0] = 1

        for _ in range(m):
            for col in range(n):
                if col > 0:
                    dp[col] += dp[col - 1]

        return dp[n - 1]
