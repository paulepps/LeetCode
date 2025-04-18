class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[][] newIntervals = new int[intervals.length + 1][2];

        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }

        newIntervals[intervals.length] = newInterval;

        return merge(newIntervals);
    }

    int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] prev = res.get(res.size() - 1);
            int[] curr = intervals[i];

            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                res.add(curr);
            }
        }
        return res.toArray(new int[0][]);
    }

}