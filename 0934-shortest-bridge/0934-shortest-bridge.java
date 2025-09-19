class Solution {
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean[][] visited;
    private Queue<Pair> q; 
    private int[][] grid;
    private int n;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        visited = new boolean[n][n];
        q = new LinkedList<>();
        boolean foundFirstIsland = false;

        // Find the first island using DFS and populate the queue
        for (int i = 0; i < n && !foundFirstIsland; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    foundFirstIsland = true;
                    break; 
                }
            }
        }

        // Expand the island using BFS
        int move = 0;
        int[] dx = {-1, 1, 0, 0}; 
        int[] dy = {0, 0, -1, 1}; 

        while (true) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pair p = q.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (nx >= 0 && nx < n && 
                            ny >= 0 && ny < n && 
                            !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if (grid[nx][ny] == 1) {
                            return move; // Found the second island
                        }
                        // Add cell to queue for expansion
                        q.offer(new Pair(nx, ny)); 
                    }
                }
            }
            // Increment bridge length after each layer of expansion
            move++; 
        }
    }

    private void dfs(int r, int c) {
        if (r < 0 || r >= n || 
            c < 0 || c >= n || 
            visited[r][c] || grid[r][c] == 0) {
            return;
        }

        visited[r][c] = true;
        
        q.offer(new Pair(r, c)); // Add to queue for BFS
        
        dfs(r + 1, c);
        dfs(r - 1, c);
        dfs(r, c + 1);
        dfs(r, c - 1);
    }
}