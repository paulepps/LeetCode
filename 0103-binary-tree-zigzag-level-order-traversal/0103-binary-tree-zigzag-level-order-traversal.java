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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        boolean reverse = false;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                TreeNode node;
                if (reverse) {
                    node = q.pollLast();
                } else {
                    node = q.poll();
                }

                list.add(node.val);

                if (i == levelSize - 1) {
                    result.add(list);
                }

                if (reverse) {
                    if (node.right != null) {
                        q.addFirst(node.right);
                    }
                    if (node.left != null) {
                        q.addFirst(node.left);
                    }
                } else {
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
            }
            reverse = !reverse;
        }
        return result;
        
    }
}