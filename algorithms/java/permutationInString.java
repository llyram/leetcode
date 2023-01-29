class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] inp = new int[26];

        for(char c: s1.toCharArray()) {
            inp[c - 'a']++;
        }

        int[] chk = new int[26];
        int matches = 0;

        for(int i=0; i<26; i++) {
            if(inp[i] == chk[i]){
                matches++;
            }
        }

        for(int i=0; i<s2.length(); i++) {
            int next = s2.charAt(i) - 'a';
            if(chk[next] == inp[next]) matches--;
            chk[next]++;
            if(chk[next] == inp[next]) matches++;

            if(i >= s1.length()) {
                int prev = s2.charAt(i-s1.length()) - 'a';
                if(chk[prev] == inp[prev]) matches--;
                chk[prev]--;
                if(chk[prev] == inp[prev]) matches++;
            }

            if(matches == 26) {
                return true;
            }

        }

        return false;
    }
}