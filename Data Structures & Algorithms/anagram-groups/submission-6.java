class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use map to store character counts sting to word list
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] cnts = new int[26];
            for(char c : str.toCharArray()){
                cnts[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i : cnts){
                sb.append(i).append(',');
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
// time: O(n * k), where n is the number of strings and k is the average length of each string
// space: O(n * k) n * k
