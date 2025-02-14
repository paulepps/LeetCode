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
    private int[] preorderTraversal;
    private Map<Integer, Integer> inorderIndices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        this.preorderTraversal = preorder;

        for (int i = 0; i < n; i++) {
            inorderIndices.put(inorder[i], i);
        }

        return buildTreeRecursive(0, 0, n);
    }

    private TreeNode buildTreeRecursive(int preorderIdx, int inorderIdx, int size) {
        if (size <= 0) {
            return null;
        }

        int rootValue = preorderTraversal[preorderIdx];
        int inorderRootIndex = inorderIndices.get(rootValue);
        int leftSubtreeSize = inorderRootIndex - inorderIdx;

        TreeNode leftSubtree = buildTreeRecursive(preorderIdx + 1, 
                                                  inorderIdx,
                                                  leftSubtreeSize);
        
        TreeNode rightSubtree = buildTreeRecursive(preorderIdx + 1 + leftSubtreeSize,
                                                   inorderRootIndex + 1,
                                                   size - 1 - leftSubtreeSize);

        return new TreeNode(rootValue, leftSubtree, rightSubtree);
    }
}