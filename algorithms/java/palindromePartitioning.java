class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        

        dfs(res, cur, s, 0);

        return res;
    }

    public void dfs(List<List<String>> res, List<String> cur, String s, int i) {
        if(i == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int j=i; j<s.length(); j++) {
            if(isPalindrome(s, i, j)) {
                cur.add(s.substring(i, j+1));
                dfs(res, cur, s, j+1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i+=1;
            j-=1;

        }
        return true;

    }
}