class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, Comparator.comparingInt(interval -> interval[1]));

        int count = 0;

        long prevPosition = Long.MIN_VALUE;

        for (int[] interval : points) {
            int start = interval[0];
            int end = interval[1];

            if (start > prevPosition) {
                count++;
                prevPosition = end;
            }
        }
        return count;
    }
}