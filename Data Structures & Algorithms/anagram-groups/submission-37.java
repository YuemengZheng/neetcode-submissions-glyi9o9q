class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); // 
        for(String s : strs) {
            int[] arr = new int[26];
            for(char c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            String freq = Arrays.toString(arr);//
            map.computeIfAbsent(freq, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
