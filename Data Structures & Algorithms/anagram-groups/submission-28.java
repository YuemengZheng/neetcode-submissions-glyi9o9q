class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use a hashmap to group all the anagrams
        // the key is the character count, values is a list of the string that match that character count
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] cnts = new int[26];
            for(char c : str.toCharArray()) {
                cnts[c - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(cnts), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
