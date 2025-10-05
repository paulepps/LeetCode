class Solution:
    def __init__(self):
        self.perms: List[List[int]] = []
        self.curr: List[int] = []
        self.elements: List[int] = []
        self.visited: List[bool] = []

    def permute(self, nums: List[int]) -> List[List[int]]:
        self.elements = nums
        self.visited = [False] * len(nums)
        self._dfs(0)
        return self.perms

    def _dfs(self, index: int) -> None:
        if index == len(self.elements):
            self.perms.append(self.curr[:])  # Copy current path
            return

        for j in range(len(self.elements)):
            if not self.visited[j]:
                self.visited[j] = True
                self.curr.append(self.elements[j])
                self._dfs(index + 1)
                self.curr.pop()
                self.visited[j] = False
