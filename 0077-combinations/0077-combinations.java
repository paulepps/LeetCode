class Solution {
    private final List<List<Integer>> combos = new ArrayList<>();
    private final List<Integer> curr = new ArrayList<>();
    private int n;
    private int k;
    
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(1);
        return combos;
    }

    private void dfs(int i) {

        if (curr.size() == k) {
            combos.add(new ArrayList<>(curr));
            return;
        }

        if (i > n) {
            return;
        }

        curr.add(i);
        dfs(i + 1);

        curr.remove(curr.size() - 1);
        dfs(i + 1);
    }
}