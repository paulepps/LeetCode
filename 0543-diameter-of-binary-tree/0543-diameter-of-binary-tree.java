/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {

        diameter = 0;

        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);

        diameter = Math.max(diameter, lDepth + rDepth);

        return Math.max(lDepth, rDepth) + 1;
    }
};
