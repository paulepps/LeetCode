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
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToBST(nums, 0, nums.length - 1);
    }

    private TreeNode convertToBST(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = convertToBST(arr, start, mid - 1);
        root.right = convertToBST(arr, mid + 1, end);

        return root;
    }
}