class Solution {

    private List<String> result = new ArrayList<>();
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        solve(0, 0, "");
        return result;    
    }

    private void solve(int l, int r, String s) {
        if (l > n || r > n || l < r) {
            return;
        }
        if (l == n && r == n) {
            result.add(s);
        }
        solve(l + 1, r, s + "(");
        solve(l, r + 1, s + ")");
    }
}