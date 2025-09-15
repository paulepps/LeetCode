from typing import List

class Solution:
    def __init__(self):
        self.board: List[List[str]] = []
        self.num_rows = 0
        self.num_cols = 0

    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return

        self.board = board
        self.num_rows = len(board)
        self.num_cols = len(board[0])

        # Mark border-connected 'O's
        for i in range(self.num_rows):
            for j in range(self.num_cols):
                if (i == 0 or i == self.num_rows - 1 or
                    j == 0 or j == self.num_cols - 1) and self.board[i][j] == 'O':
                    self.dfs(i, j)

        # Flip the cells accordingly
        for i in range(self.num_rows):
            for j in range(self.num_cols):
                if self.board[i][j] == '.':
                    self.board[i][j] = 'O'
                elif self.board[i][j] == 'O':
                    self.board[i][j] = 'X'

    def dfs(self, row: int, col: int) -> None:
        if (row < 0 or row >= self.num_rows or
            col < 0 or col >= self.num_cols or
            self.board[row][col] != 'O'):
            return

        self.board[row][col] = '.'

        self.dfs(row + 1, col)
        self.dfs(row - 1, col)
        self.dfs(row, col + 1)
        self.dfs(row, col - 1)

        