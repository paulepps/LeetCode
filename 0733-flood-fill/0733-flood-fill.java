class Solution {

    private int color;
    private int targetColor;
    private int rowCount;
    private int colCount;
    private int[][] image;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        this.color = color;
        this.image = image;

        rowCount = image.length;
        colCount = image[0].length;
  
        // Target color to replace
        targetColor = image[sr][sc];

        // Call the dfs function on the starting pixel.
        dfs(sr, sc);

        // Return the updated image after the flood fill.
        return image;
    }

    /**
     * Recursive depth-first search function to perform the color fill.
     */
    private void dfs(int row, int col) {
        // Check if the current pixel is outside the image boundaries,
        // already has the new color, or is not matching the target color.
        if (
            row < 0 || row == rowCount ||
            col < 0 || col == colCount ||
            image[row][col] != targetColor ||
            image[row][col] == color
        ) {
            // Exit the function without further processing.
            return;
        }

        // Fill the current pixel with the new color.
        image[row][col] = color;

        // Recursively apply the fill operation to the neighboring pixels.
        dfs(row + 1, col); // Down
        dfs(row - 1, col); // Up
        dfs(row, col + 1); // Right
        dfs(row, col - 1); // Left
    }
}