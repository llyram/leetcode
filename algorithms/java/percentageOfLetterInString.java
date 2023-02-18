class Solution {
    public int percentageLetter(String s, char letter) {
        int charCount = 0;
        for (char c: s.toCharArray()) {
            if (c == letter) {
                charCount ++;
            }
        }
        
        System.out.println(charCount);
        
        return ((charCount * 100) / s.length());
    }
}