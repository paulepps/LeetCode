class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        
        int[] states = new int[n]; // 0: unvisited, 1: visiting, 2: safe
        
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, states)) {
                safeNodes.add(i);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }

    private boolean dfs(int u, int[][] graph, int[] states) {
        if (states[u] == 1) { // Currently visiting, indicates a cycle
            return false;
        }
        if (states[u] == 2) { // Already determined as safe
            return true;
        }

        states[u] = 1; // Mark as visiting

        for (int v : graph[u]) {
            if (!dfs(v, graph, states)) {
                return false; // If any path from a neighbor leads to a cycle, this node is not safe
            }
        }

        states[u] = 2; // All paths from this node lead to terminal nodes or other safe nodes
        return true;
    }
}
