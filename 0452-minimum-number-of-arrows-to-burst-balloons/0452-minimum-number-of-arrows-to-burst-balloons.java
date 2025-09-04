class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort points by their endpoint
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));

        int end = points[0][1]; // Endpoint of the first selected balloon
        int arrows = 1;

        for (int i = 1; i < points.length; i++) {
            // Current balloon's start is after the previous end
            if (points[i][0] > end) { 
                arrows++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return arrows; 

    }
}