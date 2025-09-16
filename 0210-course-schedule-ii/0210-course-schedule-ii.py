from collections import deque
from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # Build adjacency list
        graph = [[] for _ in range(numCourses)]
        in_degrees = [0] * numCourses

        # Fill graph and indegree array
        for course, prereq in prerequisites:
            graph[prereq].append(course)
            in_degrees[course] += 1

        # Initialize queue with courses having no prerequisites
        queue = deque([i for i in range(numCourses) if in_degrees[i] == 0])

        order = []
        course_count = 0

        while queue:
            course = queue.popleft()
            order.append(course)
            course_count += 1

            for neighbor in graph[course]:
                in_degrees[neighbor] -= 1
                if in_degrees[neighbor] == 0:
                    queue.append(neighbor)

        return order if course_count == numCourses else []
