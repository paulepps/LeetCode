function floodFill(image: number[][], sr: number, sc: number, color: number): number[][] {
    const rowCount: number = image.length;
    const colCount: number = image[0].length;
  
    // Target color to replace
    const targetColor: number = image[sr][sc];

    /**
     * Recursive depth-first search function to perform the color fill.
     *
     * @param {number} row - The current row index.
     * @param {number} col - The current column index.
     */
    function dfs(row: number, col: number): void {
        // Check if the current pixel is outside the image boundaries,
        // already has the new color, or is not matching the target color.
        if (
            row < 0 || row === rowCount ||
            col < 0 || col === colCount ||
            image[row][col] !== targetColor ||
            image[row][col] === color
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

    // Call the dfs function on the starting pixel.
    dfs(sr, sc);

    // Return the updated image after the flood fill.
    return image;
}