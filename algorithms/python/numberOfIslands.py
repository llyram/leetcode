class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        islands = 0
        visited = [[False]*cols for _ in range(rows)]

        def findneighbours(i, j):
            print(i, j)
            if(i > 0 and not visited[i-1][j] and grid[i-1][j] == "1"):
                visited[i-1][j] = True
                findneighbours(i-1, j)
            if(i<rows-1 and not visited[i+1][j] and grid[i+1][j] == "1"):
                visited[i+1][j] = True
                findneighbours(i+1, j)
            if(j > 0 and grid[i][j-1] == "1" and not visited[i][j-1]):
                visited[i][j-1] = True
                findneighbours(i, j-1)
            if(j < cols-1 and not visited[i][j+1] and grid[i][j+1] == "1"):
                visited[i][j+1] = True
                findneighbours(i, j+1)

        for i in range(rows):
            for j in range(cols):
                if visited[i][j]:
                    continue
                if grid[i][j] == "1":
                    islands += 1
                    visited[i][j] = True
                    findneighbours(i, j)

        return islands