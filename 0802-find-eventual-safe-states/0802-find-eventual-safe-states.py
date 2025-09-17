from typing import List

class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        states = [0] * n  # 0: unvisited, 1: visiting, 2: safe
        safe_nodes = []

        def dfs(u: int) -> bool:
            if states[u] == 1:  # Currently visiting, indicates a cycle
                return False
            if states[u] == 2:  # Already determined as safe
                return True

            states[u] = 1  # Mark as visiting

            for v in graph[u]:
                if not dfs(v):
                    return False  # Any path to a cycle means not safe

            states[u] = 2  # All paths lead to safe nodes
            return True

        for i in range(n):
            if dfs(i):
                safe_nodes.append(i)

        safe_nodes.sort()
        return safe_nodes
