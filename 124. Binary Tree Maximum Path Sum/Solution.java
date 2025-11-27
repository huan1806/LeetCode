class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSum2(root);
        return ans;
    }

    private int maxPathSum2(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = Math.max(0, maxPathSum2(root.left));
        int maxRight = Math.max(0, maxPathSum2(root.right));
        ans = Math.max(ans, root.val + maxLeft + maxRight);
        return root.val + Math.max(maxLeft, maxRight);
    }
}