class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int oranges = 0;
        int rotten = 0;
        int time = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) oranges++;

                if (grid[i][j] == 2) {
                    oranges++;
                    q.offer(new int[]{i, j});
                }
            }
        }

        if (oranges == 0) return 0;

        int[] directions = new int[]{-1, 0, 1, 0, -1};

        while (!q.isEmpty() && rotten < oranges) {
            int size = q.size();

            rotten += size;
            if (rotten == oranges) return time;

            time++;

            for (int s = 0; s < size; s++) {
                int[] orange = q.poll();

                for (int d = 0; d < 4; d++) {
                    int i = orange[0] + directions[d];
                    int j = orange[1] + directions[d + 1];
                    if (i >= 0 && i < m && j >=0 && j < n && grid[i][j] == 1){
                        grid[i][j] = 2;
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }
        return -1;
    }
}