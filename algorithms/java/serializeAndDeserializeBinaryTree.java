/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

       List<String> list = new ArrayList<>();
       serializeDfs(list, root);

       return String.join(",", list);

    }

    public void serializeDfs(List<String> list, TreeNode root) {

        if(root == null) {
            list.add("N");
            return;
        }

        list.add(String.valueOf(root.val));

        serializeDfs(list, root.left);
        serializeDfs(list, root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        return deserializeDfs(nodes);
        
    }
    private int i;
    public TreeNode deserializeDfs(String[] nodes) {
        String token = nodes[this.i];
        if(token.equals("N")) {
            this.i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(token));
        this.i++;
        node.left = deserializeDfs(nodes);
        node.right = deserializeDfs(nodes);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));