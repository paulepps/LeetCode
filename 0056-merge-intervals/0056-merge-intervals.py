class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        res = [intervals[0]]

        for i in range(1, len(intervals)):
            prev = res[-1]
            curr = intervals[i]

            if curr[0] <= prev[1]:
                prev[1] = max(prev[1], curr[1])
            else:
                res.append(curr)

        return res
