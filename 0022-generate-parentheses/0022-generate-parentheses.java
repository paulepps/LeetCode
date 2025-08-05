class Solution {

    private List<String> result = new ArrayList<>();
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtrack(0, 0, "");
        return result;    
    }

    private void backtrack(int openCount, int closeCount, String currentString) {
        if (openCount == n && closeCount == n) {
            result.add(currentString);
            return;
        }

        if (openCount < n) {
            backtrack(openCount + 1, closeCount, currentString + "(");
        }

        if (closeCount < openCount) {
            backtrack(openCount, closeCount + 1, currentString + ")");
        }
    }
}
