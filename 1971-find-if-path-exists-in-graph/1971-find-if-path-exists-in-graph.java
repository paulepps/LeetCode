class Solution {

    private boolean[] visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        Graph G = new Graph(n);
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            G.addEdge(u, v);
        }

        visited = new boolean[G.V()];

        return dfs(G, source, destination);
    }
    
    private boolean dfs(Graph G, int v, int dest) {

        if (v == dest) {
            return true;
        } 

        visited[v] = true;
        for (int w : G.adj(v)) {
            if (!visited[w] && dfs(G, w, dest)) {
                return true;
            }
        }
        return false;
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

    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }


    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}