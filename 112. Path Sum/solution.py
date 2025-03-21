# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        return (
            root is not None
            and (
                self.hasPathSum(root.left, targetSum - root.val)
                or self.hasPathSum(root.right, targetSum - root.val)
                or root.left is None and root.right is None and targetSum - root.val == 0
            )
        )