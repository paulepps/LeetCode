class Solution:
    def numSquares(self, n: int) -> int:
        dp = [float('inf')] * (n + 1)
        dp[0] = 0

        count = 1
        sq = count * count

        while sq <= n:
            for i in range(sq, n + 1):
                dp[i] = min(dp[i - sq] + 1, dp[i])
            count += 1
            sq = count * count

        return dp[n]
