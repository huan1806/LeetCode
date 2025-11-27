class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode node, int max) {
        if (node == null) return 0;
        int cnt = 0;
        if (node.val >= max) {
            cnt++;
            max = node.val;
        }
        return cnt + goodNodes(node.left, max) + goodNodes(node.right, max);
    }
}