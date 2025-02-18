class Solution {
    private final List<List<Integer>> perms = new ArrayList<>();
    private final List<Integer> curr = new ArrayList<>();
    private int[] elements;
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        elements = nums;
        visited = new boolean[nums.length];
        dfs(0);
        return perms;
    }

    private void dfs(int index) {

        if (index == elements.length) {
            perms.add(new ArrayList<>(curr));
            return;
        }

        for (int j = 0; j < elements.length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                curr.add(elements[j]);
                dfs(index + 1);

                curr.remove(curr.size() - 1);
                visited[j] = false;
            }
        }
    }
}