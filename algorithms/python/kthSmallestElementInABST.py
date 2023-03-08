# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        nodes = []
        def inorder(root):
            if root == None:
                return
            if not root.left == None:
                inorder(root.left)
                
            nodes.append(root.val)
            
            if not root.right == None:
                inorder(root.right)
            
            
        
        inorder(root)
        print(nodes)
        
        return nodes[k-1]
        