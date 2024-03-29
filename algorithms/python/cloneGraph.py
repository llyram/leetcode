"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        nodemap = {}

        def dfs(n):
            if n in nodemap:
                return nodemap[n]

            copy = Node(n.val)
            nodemap[n] = copy
            
            for neighbor in n.neighbors:
                copy.neighbors.append(dfs(neighbor))
            
            return copy
        

        return dfs(node)


            
