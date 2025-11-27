//public class Codec {
//    private static final Map<Integer, TreeNode> store = new HashMap<>();
//    private static int id = 0;
//
//    public String serialize(TreeNode root) {
//        store.put(++id, root);
//        return String.valueOf(id);
//    }
//
//    public TreeNode deserialize(String data) {
//        return store.get(Integer.parseInt(data));
//    }
//}

class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderTraversal(root, sb);
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");
        return recoverTreeNode(nodeValues, new AtomicInteger(0));
    }

    private void preorderTraversal(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("#,");
            return;
        }
        res.append(root.val).append(',');
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }

    private TreeNode recoverTreeNode(String[] nodeValues, AtomicInteger idx) {
        String v = nodeValues[idx.getAndIncrement()];
        if (v.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(v));
        node.left = recoverTreeNode(nodeValues, idx);
        node.right = recoverTreeNode(nodeValues, idx);
        return node;
    }
}