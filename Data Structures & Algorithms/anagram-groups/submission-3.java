class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] cnts = new int[26];
            for(char c : s.toCharArray()){
                cnts[c - 'a']++;
            }
            String key = Arrays.toString(cnts);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
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
        // return new ArrayList<>(map.values()); // map.values() - 》Collection<List<String>>，需要转list
    }
}
// time: O(n * k), 每个word都要形成一个cnt string ｜ 如果是sorting => n * klogk
// space: O(n * k) 每个 cnt string 是key， value是所有的words 
