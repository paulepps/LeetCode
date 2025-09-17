function eventualSafeNodes(graph: number[][]): number[] {
    const n: number = graph.length;
    const states: number[] = new Array(n).fill(0); // 0: unvisited, 1: visiting, 2: safe
    const safeNodes: number[] = [];

    const dfs = (u: number): boolean => {
        if (states[u] === 1) { // Currently visiting, indicates a cycle
            return false;
        }
        if (states[u] === 2) { // Already determined as safe
            return true;
        }

        states[u] = 1; // Mark as visiting

        for (const v of graph[u]) {
            if (!dfs(v)) {
                return false; // Any path to a cycle means not safe
            }
        }

        states[u] = 2; // All paths lead to safe nodes
        return true;
    };

    for (let i = 0; i < n; i++) {
        if (dfs(i)) {
            safeNodes.push(i);
        }
    }

    safeNodes.sort((a, b) => a - b);
    return safeNodes;
}
