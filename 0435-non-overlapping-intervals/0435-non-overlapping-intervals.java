class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int end = intervals[0][1]; // End time of the first selected interval
        int count = 1; // Count of non-overlapping intervals

        for (int i = 1; i < intervals.length; i++) {
            // Current interval's start is after or at the previous end
            if (intervals[i][0] >= end) { 
                count++;
                end = intervals[i][1]; // Update end to the current interval's end
            }
        }
        // The result is total intervals minus the count of non-overlapping ones
        return intervals.length - count; 
    }
}