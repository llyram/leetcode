class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();

        for(String word:words){
            root.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        Set<String> res = new HashSet<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dfs(board, i, j, m, n, new boolean[m][n], root, res);
            }
        }

        return res.stream().collect(Collectors.toList());
    }

    public void dfs(char[][] board, int i, int j, int m, int n, boolean[][] traversed, Trie trie, Set<String> res) {
        if(trie.word != null) {
            res.add(trie.word);
        }
        if(
            i < 0 || i >= m ||
            j < 0 || j >= n ||
            traversed[i][j] ||
            trie.children[board[i][j] - 'a'] == null
        ) {
            return;
        }

        trie = trie.children[board[i][j] - 'a'];
        traversed[i][j] = true;

        dfs(board, i+1, j, m, n, traversed, trie, res);
        dfs(board, i-1, j, m, n, traversed, trie, res);
        dfs(board, i, j+1, m, n, traversed, trie, res);
        dfs(board, i, j-1, m, n, traversed, trie, res);

        traversed[i][j] = false;
    }

    class Trie {
        private Trie[] children;
        private String word;

        public Trie() {
            this.children = new Trie[26];
            this.word = null;
        }

        public void insert(String word) {
            Trie cur = this;
            for(char c:word.toCharArray()) {
                if(cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Trie();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
    }
}