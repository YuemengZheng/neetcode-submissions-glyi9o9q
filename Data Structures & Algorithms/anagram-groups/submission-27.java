class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] cnts = new int[26];
            for(char ch : str.toCharArray()){
                cnts[ch - 'a']++;
            }
            //String key = cnts.toString();// 这样返回的是地址不是内容
            String key = Arrays.toString(cnts);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
