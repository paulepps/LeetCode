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
    public boolean isValidBST(TreeNode root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBSTUtil(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val < min || node.val > max) return false;

        return isBSTUtil(node.left, min, (long)node.val - 1) &&
               isBSTUtil(node.right, (long)node.val + 1, max);
    }
}