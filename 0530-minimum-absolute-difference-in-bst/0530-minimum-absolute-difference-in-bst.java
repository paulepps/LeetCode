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

    private int ans = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode curr) {
        if (curr == null)
            return;

        inorder(curr.left);

        if (prev != null) {
            ans = Math.min(ans, curr.val - prev.val);
        }
        prev = curr;

        inorder(curr.right);
    }
}