class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return board
        ROWS, COLS = len(board), len(board[0])
        visited = set()
        # safe = set()

        def dfs(i, j):
            for x,y in [(1,0),(-1,0),(0,1),(0,-1)]:
                r,c = i+x, j+y
                if(
                    (r,c) not in visited and
                    r in range(ROWS) and
                    c in range(COLS) and
                    board[r][c] == "O"
                ) :
                    visited.add((r,c))
                    dfs(r,c)


        for i in range(ROWS):
            for j in range(COLS):
                if i in range(1,ROWS-1) and j in range(1,COLS-1):
                    continue
                if (i,j) in visited:
                    continue
                if board[i][j] == "O":
                    visited.add((i,j))
                    dfs(i,j)


        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] == "O" and (i,j) not in visited:
                    board[i][j] = "X"