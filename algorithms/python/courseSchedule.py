class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = {}
        visited = set()

        for course in range(numCourses):
            adj[course] = []

        for prerequisite in prerequisites:
            course, pre = prerequisite
            adj[course].append(pre)
        
        def dfs(course):
            if course in visited:
                return False
            if not adj[course]:
                return True
            
            visited.add(course)
            for pre in adj[course]:
                if not dfs(pre):
                    return False

            visited.remove(course)
            adj[course] = []
            return True

        for course in adj:
            if not dfs(course):
                return False
        
        return True
        
