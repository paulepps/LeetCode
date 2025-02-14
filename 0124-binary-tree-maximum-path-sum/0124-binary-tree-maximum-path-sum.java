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

    private int maxSum = Integer.MIN_VALUE; 

    public int maxPathSum(TreeNode root) {
        calculateMaxSum(root);
        return maxSum;       
    }

    private int calculateMaxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMaxSum = Math.max(0, calculateMaxSum(node.left));
        int rightMaxSum = Math.max(0, calculateMaxSum(node.right));

        maxSum = Math.max(maxSum, node.val + leftMaxSum + rightMaxSum);

        return node.val + Math.max(leftMaxSum, rightMaxSum);
    }
}