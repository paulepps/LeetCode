class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n < 2:
            return s

        dp = [[False] * n for _ in range(n)]
        start = 0
        max_len = 1

        # Every single character is a palindrome
        for i in range(n):
            dp[i][i] = True

        # Check for two-character palindromes
        for i in range(n - 1):
            if s[i] == s[i + 1]:
                dp[i][i + 1] = True
                start = i
                max_len = 2

        # Check palindromes longer than 2 characters
        for k in range(3, n + 1):
            for i in range(n - k + 1):
                j = i + k - 1
                if dp[i + 1][j - 1] and s[i] == s[j]:
                    dp[i][j] = True
                    if k > max_len:
                        start = i
                        max_len = k

        return s[start:start + max_len]
