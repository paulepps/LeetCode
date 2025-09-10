class Solution {

    private int destination;           // Target node to reach
    private boolean[] visited;         // Track visited nodes to avoid cycles
    private List<Integer>[] graph;     // Adjacency list representation of graph
  
    /**
     * Determines if there exists a valid path between source and destination nodes
     * @param n Number of nodes in the graph (0 to n-1)
     * @param edges Array of edges where edges[i] = [u, v] represents an undirected edge
     * @param source Starting node
     * @param destination Target node
     * @return true if a path exists from source to destination, false otherwise
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Initialize destination for DFS
        this.destination = destination;
      
        // Initialize visited array to track explored nodes
        visited = new boolean[n];
      
        // Initialize adjacency list for graph representation
        graph = new List[n];
        Arrays.setAll(graph, index -> new ArrayList<>());
      
        // Build undirected graph by adding edges in both directions
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);  // Add edge from u to v
            graph[v].add(u);  // Add edge from v to u (undirected)
        }
      
        // Perform DFS starting from source node
        return dfs(source);
    }
  
    /**
     * Depth-First Search to find path to destination
     * @param currentNode Current node being explored
     * @return true if destination is reachable from current node, false otherwise
     */
    private boolean dfs(int currentNode) {
        // Base case: reached destination
        if (currentNode == destination) {
            return true;
        }
      
        // Mark current node as visited
        visited[currentNode] = true;
      
        // Explore all unvisited neighbors
        for (int neighbor : graph[currentNode]) {
            // Only explore unvisited neighbors to avoid cycles
            if (!visited[neighbor] && dfs(neighbor)) {
                return true;  // Path found through this neighbor
            }
        }
      
        // No path found from current node
        return false;
    }
}