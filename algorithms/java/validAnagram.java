class Solution {
    public boolean isAnagram(String s, String t) {
        int a[] = new int[26];

        for(char i: s.toCharArray()) {
            a[i-'a']++;
        }

        for(char i: t.toCharArray()) {
            a[i-'a']--;
        }

        for(int i:a) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}