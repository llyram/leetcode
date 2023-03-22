class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node('\0');
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char c:word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, Node curr, int index) {

        for(int i=index; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.')  {
                for(Node temp:curr.children) {
                    if(temp != null && searchHelper(word, temp, i+1)) {
                        return true;
                    }
                }

                return false;
            }
            if(curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isWord;
    }

    public class Node {
        private char value;
        private Node[] children;
        private boolean isWord;

        public Node(char val) {
            children = new Node[26];
            this.value = val;
            isWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
// //  */