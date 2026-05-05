class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] count = new int[26];
            for(char a: str.toCharArray()) {
                count[a - 'a']++; 
            }
            StringBuilder sb = new StringBuilder();
            for(int c: count) {
                sb.append(c).append(",");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
