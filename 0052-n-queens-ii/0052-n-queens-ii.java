class Solution {
    public int totalNQueens(int n) {
        return solve(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int solve(int row, int n, 
                        Set<Integer> cols,
                        Set<Integer> diags1,
                        Set<Integer> diags2)
    {
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {
            int diag1 = row - col;
            int diag2 = row + col;

            if (!cols.contains(col) &&
                !diags1.contains(diag1) &&
                !diags2.contains(diag2)) {
                    cols.add(col);
                    diags1.add(diag1);
                    diags2.add(diag2);

                    count += solve(row + 1, n, cols, diags1, diags2);

                    cols.remove(col);
                    diags1.remove(diag1);
                    diags2.remove(diag2);
            }            
        }
        return count;
    }
}