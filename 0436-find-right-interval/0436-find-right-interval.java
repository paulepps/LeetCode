class Solution {
    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;
        int[] result = new int[n];

        // Store start points and their original indices in a TreeMap
        // TreeMap automatically keeps keys sorted and allows 
        // efficient ceilingEntry lookup
        TreeMap<Integer, Integer> startToIndex = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            startToIndex.put(intervals[i][0], i);
        }

        // Iterate through original intervals
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];

            // Find the entry with the smallest key >= end
            Map.Entry<Integer, Integer> rightEntry 
                = startToIndex.ceilingEntry(end);

            if (rightEntry == null) {
                // No right interval found
                result[i] = -1;
            } else {
                // Found a right interval, store its original index
                result[i] = rightEntry.getValue();
            }
        }
        return result;
    }
}