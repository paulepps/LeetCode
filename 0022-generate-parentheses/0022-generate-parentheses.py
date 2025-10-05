from typing import List

class Solution:
    def __init__(self):
        self.result: List[str] = []
        self.n: int = 0

    def generateParenthesis(self, n: int) -> List[str]:
        self.n = n
        self._backtrack(0, 0, "")
        return self.result

    def _backtrack(self, open_count: int, close_count: int, current_string: str) -> None:
        if open_count == self.n and close_count == self.n:
            self.result.append(current_string)
            return

        if open_count < self.n:
            self._backtrack(open_count + 1, close_count, current_string + "(")

        if close_count < open_count:
            self._backtrack(open_count, close_count + 1, current_string + ")")
