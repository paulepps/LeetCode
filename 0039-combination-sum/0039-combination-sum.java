class Solution {
    private final List<List<Integer>> combos = new ArrayList<>();
    private final List<Integer> curr = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(0, target);
        return combos;
    }

    private void dfs(int index, int remainingSum) {

        if (remainingSum == 0) {
            combos.add(new ArrayList<>(curr));
            return;
        }

        if (index >= candidates.length || remainingSum < candidates[index]) {
            return;
        }

        dfs(index + 1, remainingSum);

        curr.add(candidates[index]);
        dfs(index, remainingSum - candidates[index]);

        curr.remove(curr.size() - 1);
    }
}