class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int max_length = 0;
        for(int i=0, j=0; j<s.length(); j++) {
            if (map.keySet().contains(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
                
            }
            map.put(s.charAt(j), j);
            
            max_length = Math.max(max_length, j-i+1);
            
        }
        
        return max_length;
    }
}