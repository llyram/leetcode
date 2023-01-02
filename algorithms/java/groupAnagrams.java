class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String, List<String>> map = new HashMap<>();

        for(String str: strs) { // loop through each string in the input array
            char a[] = new char[26]; // initialize a char array of size 26
            for(char c: str.toCharArray()) { // create frequency array of each character
                a[c-'a']++;
            }

            String uq = String.valueOf(a); // create a unique string to identify anagrams

            if(!map.containsKey(uq)) { // if the anagram is encountered for the first time create a new list in the map
                map.put(uq, new ArrayList<>());
            }
            map.get(uq).add(str); // add the string to the array list
        }

        return new ArrayList<>(map.values()); // return a list of the values of the array map
        
    }
}