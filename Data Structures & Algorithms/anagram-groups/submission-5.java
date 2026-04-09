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





        // Map<String, List<String>> map = new HashMap<>();
        // for(String s : strs){
        //     int[] cnts = new int[26];
        //     for(char c : s.toCharArray()){
        //         cnts[c - 'a']++;
        //     }
        //     String key = Arrays.toString(cnts);
        //     map.putIfAbsent(key, new ArrayList<>());
        //     map.get(key).add(s);
        // }
        // return new ArrayList<>(map.values());



    }
}
// time: O(n * k), 每个word都要形成一个cnt string ｜ 如果是sorting => n * klogk
// space: O(n) n * 26 ｜ 如果是sorting => n * k
