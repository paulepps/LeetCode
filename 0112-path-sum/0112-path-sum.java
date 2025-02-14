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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();

        stack.push(root);
        sums.push(root.val);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int sum = sums.pop();

            if (node.left == null && node.right == null
                    && sum == targetSum) {
                return true;
            }

            if (node.left != null) {
                stack.push(node.left);
                sums.push(sum + node.left.val);
            }

            if (node.right != null) {
                stack.push(node.right);
                sums.push(sum + node.right.val);
            }

        }
        return false;
    }
}