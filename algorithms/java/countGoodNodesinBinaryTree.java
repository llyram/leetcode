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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode curr, int max) {
        if(curr == null) {
            return 0;
        }

        if (max <= curr.val) {
            max = curr.val;
            return dfs(curr.left, max) + dfs(curr.right, max) + 1;
        }

        return dfs(curr.left, max) + dfs(curr.right, max);
    }
}