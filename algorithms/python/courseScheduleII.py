class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = {x:[] for x in range(numCourses)}
        visited = set()
        order = []

        for course, pre in prerequisites:
            adj[course].append(pre)
        
        def dfs(course):
            if course in visited:
                return False
            if adj[course] == []:
                if course not in order:
                    order.append(course)
                return True
            visited.add(course)
            for pre in adj[course]:
                if not dfs(pre):
                    return False
            adj[course] = []
            visited.remove(course)
            order.append(course)
            return True
        
        for course in range(numCourses):
            if not dfs(course):
                return []
            
        return order