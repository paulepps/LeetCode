class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (arr1, arr2) -> (
            arr1[0] == arr2[0] ? arr2[1] - arr1[1] : arr1[0] - arr2[0]
        )); 

        int count = 1;
        int firstIntervalEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int secondIntervalEnd = intervals[i][1];
            if (secondIntervalEnd > firstIntervalEnd) {
                count++;
                firstIntervalEnd = secondIntervalEnd;
            }
        } 
        return count;
    }
}