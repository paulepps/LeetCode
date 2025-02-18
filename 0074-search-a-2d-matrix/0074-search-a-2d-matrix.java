class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        final int m = matrix.length;
        final int n = matrix[0].length;

        int lo = 0;
        int hi = m * n;

        while (lo < hi) {
            final int mid = (lo + hi) / 2;
            final int row = mid / n;
            final int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return false;
    }
}