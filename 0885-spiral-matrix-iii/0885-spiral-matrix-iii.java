class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] result = new int[rows * cols][2];
        result[0][0] = rStart;
        result[0][1] = cStart;

        int row = rStart;
        int col = cStart;

        int legLength = 1;
        int cellCount = 1;
        
        while (cellCount < rows * cols) {
            // left
            for (int i = 0; i < legLength; i++) {
                col++;
                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    result[cellCount][0] = row;
                    result[cellCount][1] = col;
                    cellCount++;
                }
            }
            // down
            for (int i = 0; i < legLength; i++) {
                row++;
                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    result[cellCount][0] = row;
                    result[cellCount][1] = col;
                    cellCount++;
                }
            }
            legLength++;
            // right
            for (int i = 0; i < legLength; i++) {
                col--;
                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    result[cellCount][0] = row;
                    result[cellCount][1] = col;
                    cellCount++;
                }
            }
            // up
            for (int i = 0; i < legLength; i++) {
                row--;
                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    result[cellCount][0] = row;
                    result[cellCount][1] = col;
                    cellCount++;
                }
            }
            legLength++;
        }
        return result;
    }
}