class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(search(board, word, i, j, m, n, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(
        char[][] board, 
        String word, 
        int i, 
        int j, 
        int m, 
        int n, 
        int cur
    ) {
        if(cur >= word.length()) {
            return true;
        }
        if(i < 0 || j < 0 || i >= m || j >= n || word.charAt(cur) != board[i][j]) {
            return false;
        }
        boolean exists = false;
        if(board[i][j] == word.charAt(cur)) {
            board[i][j] += 100;
            exists = 
                search(board, word, i+1, j, m, n, cur+1) ||
                search(board, word, i, j+1, m, n, cur+1) ||
                search(board, word, i-1, j, m, n, cur+1) ||
                search(board, word, i, j-1, m, n, cur+1);
            board[i][j] -= 100;
        }

        return exists;
    } 
}