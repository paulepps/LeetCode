from collections import deque
from typing import List, Tuple

class Solution:
    def __init__(self):
        self.visited: List[List[bool]] = []
        self.q: deque[Tuple[int, int]] = deque()
        self.grid: List[List[int]] = []
        self.n: int = 0

    def shortestBridge(self, grid: List[List[int]]) -> int:
        self.grid = grid
        self.n = len(grid)
        self.visited = [[False] * self.n for _ in range(self.n)]
        self.q = deque()
        found_first_island = False

        # Find the first island using DFS and populate the queue
        for i in range(self.n):
            if found_first_island:
                break
            for j in range(self.n):
                if grid[i][j] == 1:
                    self.dfs(i, j)
                    found_first_island = True
                    break

        # Expand the island using BFS
        move = 0
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        while True:
            size = len(self.q)
            for _ in range(size):
                x, y = self.q.popleft()

                for dx, dy in directions:
                    nx, ny = x + dx, y + dy

                    if 0 <= nx < self.n and 0 <= ny < self.n and not self.visited[nx][ny]:
                        self.visited[nx][ny] = True
                        if grid[nx][ny] == 1:
                            return move  # Found the second island
                        self.q.append((nx, ny))  # Add cell to queue for expansion
            move += 1  # Increment bridge length after each layer

    def dfs(self, r: int, c: int) -> None:
        if (
            r < 0 or r >= self.n or
            c < 0 or c >= self.n or
            self.visited[r][c] or self.grid[r][c] == 0
        ):
            return

        self.visited[r][c] = True
        self.q.append((r, c))  # Add to queue for BFS

        self.dfs(r + 1, c)
        self.dfs(r - 1, c)
        self.dfs(r, c + 1)
        self.dfs(r, c - 1)
