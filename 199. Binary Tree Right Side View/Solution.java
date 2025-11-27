class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    public void dfs(TreeNode node, int height, List<Integer> ans) {
        if (node == null) return;
        if (ans.size() == height) {
            ans.add(node.val);
        }
        dfs(node.right, height + 1, ans);
        dfs(node.left, height + 1, ans);
    }
}