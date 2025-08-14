class Solution {

    private int rows;
    private int cols;
    private int result[][];
    private int cellCount;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        this.rows = rows;
        this.cols = cols;

        result = new int[rows * cols][2];
        result[0][0] = rStart;
        result[0][1] = cStart;

        int row = rStart;
        int col = cStart;

        int legLength = 1;
        cellCount = 1;
        
        while (cellCount < rows * cols) {
            // left
            for (int i = 0; i < legLength; i++) {
                col++;
                checkAndAdd(row, col);
            }
            // down
            for (int i = 0; i < legLength; i++) {
                row++;
                checkAndAdd(row, col);
            }
            legLength++;
            // right
            for (int i = 0; i < legLength; i++) {
                col--;
                checkAndAdd(row, col);
            }
            // up
            for (int i = 0; i < legLength; i++) {
                row--;
                checkAndAdd(row, col);
            }
            legLength++;
        }
        return result;
    }

    private void checkAndAdd(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            result[cellCount][0] = row;
            result[cellCount][1] = col;
            cellCount++;
        }
    }
}