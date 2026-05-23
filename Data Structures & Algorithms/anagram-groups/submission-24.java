class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 用hashmap去给所有的string分组，key是string of character count
        // value is a group of anagrams
        // loop through each string, group them in the map
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] cnts = new int[26];
            for(char c : str.toCharArray()){
                cnts[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int cnt : cnts){
                sb.append(cnt).append(',');
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
