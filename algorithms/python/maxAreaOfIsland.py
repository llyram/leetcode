class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        maxArea = 0
        visited = [[False]*cols for _ in range(rows)]

        def findneighbours(i, j):
            area = 1
            if(i > 0 and not visited[i-1][j] and grid[i-1][j] == 1):
                visited[i-1][j] = True
                area += findneighbours(i-1, j)
            if(i<rows-1 and not visited[i+1][j] and grid[i+1][j] == 1):
                visited[i+1][j] = True
                area += findneighbours(i+1, j)
            if(j > 0 and grid[i][j-1] == 1 and not visited[i][j-1]):
                visited[i][j-1] = True
                area += findneighbours(i, j-1)
            if(j < cols-1 and not visited[i][j+1] and grid[i][j+1] == 1):
                visited[i][j+1] = True
                area += findneighbours(i, j+1)

            return area

        for i in range(rows):
            for j in range(cols):
                if visited[i][j]:
                    continue
                if grid[i][j] == 1:
                    visited[i][j] = True
                    maxArea = max(maxArea, findneighbours(i, j))

        return maxArea