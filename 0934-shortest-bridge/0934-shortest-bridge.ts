function shortestBridge(grid: number[][]): number {
    let n: number = grid.length;
    const visited: boolean[][] = Array.from({ length: n }, () => Array(n).fill(false));
    const q: [number, number][] = [];
    let foundFirstIsland = false;

    // Find the first island using DFS and populate the queue
    for (let i = 0; i < n; i++) {
        if (foundFirstIsland) break;
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                dfs(i, j);
                foundFirstIsland = true;
                break;
            }
        }
    }

    // Expand the island using BFS
    let move = 0;
    const directions: [number, number][] = [
        [-1, 0],
        [1, 0],
        [0, -1],
        [0, 1]
    ];

    while (true) {
        const size = q.length;
        for (let s = 0; s < size; s++) {
            const [x, y] = q.shift()!; // non-null assertion

            for (const [dx, dy] of directions) {
                const nx = x + dx;
                const ny = y + dy;

                if (
                    nx >= 0 && nx < n &&
                    ny >= 0 && ny < n &&
                    !visited[nx][ny]
                ) {
                    visited[nx][ny] = true;
                    if (grid[nx][ny] === 1) {
                        return move; // Found the second island
                    }
                    q.push([nx, ny]); // Add cell to queue for expansion
                }
            }
        }
        move++; // Increment bridge length after each layer
    }

    function dfs(r: number, c: number): void {
        if (
            r < 0 || r >= n ||
            c < 0 || c >= n ||
            visited[r][c] ||
            grid[r][c] === 0
        ) {
            return;
        }

        visited[r][c] = true;
        q.push([r, c]); // Add to queue for BFS

        dfs(r + 1, c);
        dfs(r - 1, c);
        dfs(r, c + 1);
        dfs(r, c - 1);
    }
}

