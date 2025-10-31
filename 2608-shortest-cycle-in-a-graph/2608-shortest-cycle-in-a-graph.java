class Solution {
    private final int MAX_VALUE = 9999;
    
    public int findShortestCycle(int n, int[][] edges) {

        Graph G = new Graph(n, edges) ;        

        int shortestCycleLength = MAX_VALUE;

        for (int[] edge : edges) {
            int startVertex = edge[0];
            int endVertex = edge[1];
  
            shortestCycleLength 
                = Math.min(shortestCycleLength, bfs(startVertex, endVertex, G));
        }
      
        return shortestCycleLength < MAX_VALUE ? shortestCycleLength : -1;
    }

    private int bfs(int startVertex, int endVertex, Graph G) {

        int[] distance = new int[G.V()];
        Arrays.fill(distance, MAX_VALUE);
        distance[startVertex] = 0;
      
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(startVertex);
      
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
          
            for (int neighbor : G.adj(currentVertex)) {
                // Skip the direct edge between startVertex and endVertex
                // This edge is temporarily "removed" to find alternate paths
                boolean isDirectEdge = currentVertex == startVertex && neighbor == endVertex;
              
                if (isDirectEdge || distance[neighbor] != MAX_VALUE) {
                    continue;
                }
              
                // Update distance and add neighbor to queue
                distance[neighbor] = distance[currentVertex] + 1;
                queue.offer(neighbor);
            }
        }
      
        return distance[endVertex] + 1;
    }
}

class Graph {
    private final int V;
    private List<List<Integer>> adj;

    public Graph(int V, int[][] edges) {
        this.V = V;

        adj = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }


    public int V() {
        return V;
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }


    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }
}