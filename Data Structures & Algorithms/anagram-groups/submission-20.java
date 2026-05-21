class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
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
            String s = sb.toString();

            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
