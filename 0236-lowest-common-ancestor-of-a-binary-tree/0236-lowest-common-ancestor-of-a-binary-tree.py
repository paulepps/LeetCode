# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from typing import Optional

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None

        if root == p or root == q:
            return root

        lca_left = self.lowestCommonAncestor(root.left, p, q)
        lca_right = self.lowestCommonAncestor(root.right, p, q)

        if lca_left and lca_right:
            return root

        return lca_left if lca_left else lca_right
