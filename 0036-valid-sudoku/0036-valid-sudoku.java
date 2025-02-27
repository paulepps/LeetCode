class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] subgrids = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentChar = board[i][j];

                if (currentChar == '.')
                    continue;

                int number = (currentChar - '0' - 1);

                int sgIndex = (i / 3) * 3 + j / 3;

                if (rows[i][number] || columns[j][number] 
                    || subgrids[sgIndex][number]) {
                    return false;
                }

                rows[i][number]  = true;
                columns[j][number]  = true;
                subgrids[sgIndex][number] = true;
            }
        }
        return true;
    }
}