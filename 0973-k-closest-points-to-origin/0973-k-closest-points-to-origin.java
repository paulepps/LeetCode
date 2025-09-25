class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> Q 
            = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int dist = point[0] * point[0] + point[1] * point[1];

            Q.offer(new int[]{dist, i});
         }

         int result[][] = new int[k][2];

         for (int i = 0; i < k; i++) {
            result[i] = points[Q.poll()[1]];
         } 

         return result;
    }
}