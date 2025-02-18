/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    private int[][] grid;

    public Node construct(int[][] grid) {

        this.grid = grid;
        return buildTree(0, 0, grid.length);    
    }

    private Node buildTree(int row, int col, int width) {
        if (allSame(row, col, width)) {
            return new Node(grid[row][col] == 1, true);
        }

        final int half = width / 2;

        return new Node(true, false,
                        buildTree(row, col, half),
                        buildTree(row, col + half, half),
                        buildTree(row + half, col, half),
                        buildTree(row + half, col + half, half));
    }

    private boolean allSame(int row, int col, int width) {
        for (int i = row; i < row + width; i++) {
            for (int j = col; j < col + width; j++) {
                if (grid[i][j] != grid[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}