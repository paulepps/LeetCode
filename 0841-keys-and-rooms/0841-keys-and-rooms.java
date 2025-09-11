class Solution {

    private boolean[] visited;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        Graph G = new Graph(n);
        
        for (int i = 0; i < n; i++) {
            G.addEdges(i, rooms.get(i));
        }

        visited = new boolean[n];

        dfs(G, 0);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    private void dfs(Graph G, int v) {

        visited[v] = true;
        for (int w : G.adj(v)) {
            if (!visited[w]) dfs(G, w);
        }    
    }
}

class Graph {

    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdges(int v, List<Integer> edges) {
        E += edges.size();
        adj[v] = edges;
    }


    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}