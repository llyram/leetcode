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
import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // for(int i:preorder) {
        //     System.out.print(i + " ");
        // }
        // System.out.println("");
        // for(int i:inorder) {
        //     System.out.print(i + " ");
        // }
        // System.out.println("");

        if(preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int i=0;
        while(i < inorder.length) {
            if(inorder[i] == preorder[0]) {
                break;
            }
            i++;
        }

        if(i > 0) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
        }

        if(i < preorder.length-1) {
            root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
        }

        

        return root;
    }
}