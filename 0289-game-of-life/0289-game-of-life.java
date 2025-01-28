class Solution {
    public void gameOfLife(int[][] board) {
        int length = board.length;
        int width = board[0].length;

        int[][] future = new int[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int neighbors = 0;

                for (int ii = -1; ii <= 1; ii++) {
                    for (int jj = -1; jj <= 1; jj++) {
                        if ((i + ii >= 0 && i + ii < length)
                            && (j + jj >= 0 && j + jj < width)) {
                                neighbors += board[i + ii][j + jj];
                        }
                    }
                }
                neighbors -= board[i][j];

                if (board[i][j] == 1 && neighbors < 2) {
                    future[i][j] = 0;
                }
                else if (board[i][j] == 1 && neighbors > 3) {
                    future[i][j] = 0;
                }
                else if (board[i][j] == 0 && neighbors == 3) {
                    future[i][j] = 1;
                }
                else {
                    future[i][j] = board[i][j];
                }
            }
        }
        for (int i = 0; i < future.length; i++) {
            board[i] = Arrays.copyOf(future[i], future[i].length);
        }
    }
}