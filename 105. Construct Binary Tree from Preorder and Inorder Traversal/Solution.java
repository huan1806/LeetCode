class Solution {
    Map<Integer, Integer> ii = new HashMap<>();
    int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            ii.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right) return null;
        int val = preorder[i++];
        TreeNode res = new TreeNode(val);
        int iii = ii.get(val);
        res.left = buildTree(preorder, left, iii - 1);
        res.right = buildTree(preorder, iii + 1, right);
        return res;
    }
}