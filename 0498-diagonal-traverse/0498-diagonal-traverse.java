class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        
        int[] result = new int[m * n];

        int i = 0;
        int j = 0;
        int idx = 0;
        boolean up = true;

        while (i < m && j < n) {
            if (up) {
                while (true) {
                    result[idx++] = mat[i][j];
                    if (j == n - 1) {
                        i++;
                        up = !up;
                        break;
                    }

                    if (i == 0) {
                        j++;
                        up = !up;
                        break;
                    }

                    i--;
                    j++;
                } 
            } else {
                while (true) {
                    result[idx++] = mat[i][j];
                    if (i == m - 1) {
                        j++;
                        up = !up;
                        break;
                    }

                    if (j == 0) {
                        i++;
                        up = !up;
                        break;
                    }

                    i++;
                    j--;
                }
            }
        }

        return result;
    }
}