import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    boolean[][] visited;
    Queue<Pos> q; // Queue to store cells of the first island for BFS

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        visited = new boolean[n][n];
        q = new LinkedList<>();
        boolean foundFirstIsland = false;

        // Step 1: Find the first island using DFS and populate the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, n);
                    foundFirstIsland = true;
                    break; // Only need to find one island
                }
            }
            if (foundFirstIsland) {
                break;
            }
        }

        // Step 2: Expand the island using BFS to find the shortest bridge
        int move = 0;
        int[] dx = {-1, 1, 0, 0}; // Directions for x-coordinate
        int[] dy = {0, 0, -1, 1}; // Directions for y-coordinate

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pos p = q.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if (grid[nx][ny] == 1) {
                            return move; // Found the second island
                        }
                        q.offer(new Pos(nx, ny)); // Add water cell to queue for expansion
                    }
                }
            }
            move++; // Increment bridge length after each layer of expansion
        }
        return -1; // Should not reach here if two islands always exist
    }

    // DFS to mark the first island
    private void dfs(int[][] grid, int r, int c, int n) {
        if (r < 0 || r >= n || c < 0 || c >= n || visited[r][c] || grid[r][c] == 0) {
            return;
        }
        visited[r][c] = true;
        q.offer(new Pos(r, c)); // Add to queue for BFS
        dfs(grid, r + 1, c, n);
        dfs(grid, r - 1, c, n);
        dfs(grid, r, c + 1, n);
        dfs(grid, r, c - 1, n);
    }
}