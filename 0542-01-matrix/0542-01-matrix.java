class Solution {
    public int[][] updateMatrix(int[][] mat) {
        final int m = mat.length;
        final int n = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] directions = new int[]{-1, 0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            for (int d = 0; d < 4; d++) {
                int i = cell[0] + directions[d];
                int j = cell[1] + directions[d + 1];
                if (i >= 0 && i < m && j >= 0 && j < n 
                        && mat[i][j] > mat[cell[0]][cell[1]] + 1) {
                    mat[i][j] = mat[cell[0]][cell[1]] + 1;
                    q.offer(new int[]{i, j});
                }
            }
        }
        return mat;
    }
}