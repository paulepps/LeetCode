class Solution {
    public int maxPoints(int[][] points) {
        
        int numPoints = points.length;
        int maxPointsInLine = 1;

        for (int i = 0; i < numPoints; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            Map<String, Integer> lineMap = new HashMap<>();

            for (int j = i + 1; j < numPoints; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int deltaX = x2 - x1;
                int deltaY = y2 - y1;

                int gcd = gcd(deltaX, deltaY);

                String slopeKey = (deltaX / gcd) + "." + (deltaY / gcd);
                lineMap.put(slopeKey, lineMap.getOrDefault(slopeKey, 0) + 1);

                maxPointsInLine = Math.max(maxPointsInLine, lineMap.get(slopeKey) + 1);
            }
        }
        return maxPointsInLine;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}