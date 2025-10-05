/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function lowestCommonAncestor(root: TreeNode | null, p: TreeNode | null, q: TreeNode | null): TreeNode | null {
    if (root === null) {
        return null;
    }

    if (root === p || root === q) {
        return root;
    }

    const lcaLeft = lowestCommonAncestor(root.left, p, q);
    const lcaRight = lowestCommonAncestor(root.right, p, q);

    if (lcaLeft && lcaRight) {
        return root;
    }

    return lcaLeft ?? lcaRight;
}	
