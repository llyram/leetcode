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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        list = bfs(list, root, 0);

        return list;

    }

    public List<List<Integer>> bfs(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) {
            return list;
        }

        if(list.size() <= level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);

        list = bfs(list, root.left, level+1);
        list = bfs(list, root.right, level+1);

        return list;
    }
}