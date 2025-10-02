from typing import List

class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m, n = len(text1), len(text2)
        # initialize memo with -1
        memo: List[List[int]] = [[-1] * (n + 1) for _ in range(m + 1)]
        return self._lcsRec(text1, text2, m, n, memo)

    def _lcsRec(self, text1: str, text2: str, m: int, n: int, memo: List[List[int]]) -> int:
        if m == 0 or n == 0:
            return 0

        if memo[m][n] != -1:
            return memo[m][n]

        if text1[m - 1] == text2[n - 1]:
            memo[m][n] = 1 + self._lcsRec(text1, text2, m - 1, n - 1, memo)
        else:
            memo[m][n] = max(
                self._lcsRec(text1, text2, m, n - 1, memo),
                self._lcsRec(text1, text2, m - 1, n, memo)
            )
        return memo[m][n]
