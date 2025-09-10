class Solution {

    Set<Integer> visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        visited = new HashSet<>();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        return dfs(graph, source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int source, int destination) {
        if (source == destination) {
            return true;
        }
        visited.add(source);

        for (int neighbor : graph.getOrDefault(source, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(graph, neighbor, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}