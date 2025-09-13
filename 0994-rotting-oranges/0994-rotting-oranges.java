class Solution {

    private int oranges;
    private int rotten;
    private int time;
    private int m;
    private int n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        oranges = 0;
        rotten = 0;
        time = 0;

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

        return bfs(grid, q);
    }

    private int bfs(int[][] grid, Queue<int[]> q) {

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

                    if (i >= 0 && i < m && j >=0 && j < n && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }
        return -1;
    }
}