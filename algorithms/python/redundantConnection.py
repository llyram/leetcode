class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        par = [i for i in range(len(edges)+1)]
        rank = [1 for i in range(len(edges)+1)]

        def find(n):
            p = par[n]

            while p != par[p]:
                par[p] = par[par[p]]
                p = par[p]
            
            return p

        def union(a, b):
            p1, p2 = find(a), find(b)

            if p1 == p2:
                return False
            
            if rank[p1] > rank[p2]:
                par[p2] = p1
                rank[p1] += rank[p2]
            else:
                par[p1] = p2
                rank[p2] += rank[p1]
            
            return True
        
        for a, b in edges:
            if not union(a, b):
                return [a,b]