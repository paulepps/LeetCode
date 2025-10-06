class Solution:
    def numDecodings(self, s: str) -> int:
        if s[0] == '0':
            return 0

        n = len(s)
        dp = [0] * (n + 1)

        dp[n] = 1
        dp[n - 1] = 0 if s[n - 1] == '0' else 1

        for i in range(n - 2, -1, -1):
            if s[i] == '0':
                dp[i] = 0
                continue

            dp[i] = dp[i + 1]

            two_digit_num = int(s[i:i + 2])
            if 10 <= two_digit_num <= 26:
                dp[i] += dp[i + 2]

        return dp[0]
