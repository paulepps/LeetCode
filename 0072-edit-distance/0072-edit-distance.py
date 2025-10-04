from typing import List

class Solution:
    def __init__(self):
        self.s1 = ""
        self.s2 = ""
        self.memo: List[List[int]] = []

    def minDistance(self, word1: str, word2: str) -> int:
        self.s1 = word1
        self.s2 = word2

        m, n = len(word1), len(word2)
        # initialize memo with -1
        self.memo = [[-1] * (n + 1) for _ in range(m + 1)]

        return self._editDistance(m, n)

    def _editDistance(self, m: int, n: int) -> int:
        if m == 0:
            return n
        if n == 0:
            return m

        if self.memo[m][n] != -1:
            return self.memo[m][n]

        if self.s1[m - 1] == self.s2[n - 1]:
            self.memo[m][n] = self._editDistance(m - 1, n - 1)
        else:
            insert = self._editDistance(m, n - 1)
            replace = self._editDistance(m - 1, n - 1)
            remove = self._editDistance(m - 1, n)
            self.memo[m][n] = 1 + min(insert, replace, remove)

        return self.memo[m][n]
