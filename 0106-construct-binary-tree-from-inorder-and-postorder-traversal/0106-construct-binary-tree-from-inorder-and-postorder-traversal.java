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
    private Map<Integer, Integer> inorderIndices = new HashMap<>();
    private int[] postorderTraversal;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.postorderTraversal = postorder;

        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            inorderIndices.put(inorder[i], i);
        }

        return buildTreeRecursive(0, 0, n);
    }

    private TreeNode buildTreeRecursive(int inorderIdx, int postorderIdx, int size) {

        if (size <= 0) {
            return null;
        }

        int rootValue = postorderTraversal[postorderIdx + size - 1];
        int inorderRootIndex = inorderIndices.get(rootValue);

        TreeNode rootNode = new TreeNode(rootValue);

        int leftSubtreeLength = inorderRootIndex - inorderIdx;

        rootNode.left  = buildTreeRecursive(inorderIdx, 
                                            postorderIdx, 
                                            leftSubtreeLength);
        rootNode.right = buildTreeRecursive(inorderRootIndex + 1, 
                                            postorderIdx + leftSubtreeLength,
                                            size - leftSubtreeLength - 1);

        return rootNode;
        
    }
}