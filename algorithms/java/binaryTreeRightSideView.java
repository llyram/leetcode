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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        list = dfs(root, list, 0);

        return list;
    }

    public List<Integer> dfs(TreeNode root, List<Integer> list, int level) {
        if(root == null) {
            return list;
        }

        if(list.size() <= level) {
            list.add(root.val);
        } else {
            list.set(level, root.val);
        }

        list = dfs(root.left, list, level+1);
        list = dfs(root.right, list, level+1);

        return list;
    }
}