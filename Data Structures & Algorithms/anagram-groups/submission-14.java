class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        Anagrams share the same character frequency. 
        So I use a HashMap where the key is a string representation of the character count array, 
        and the value is a list of strings with that frequency. 
        For each string, I build a character count array, 
        convert it to a string as the key, and group it. Time is O(m × n) 
        where m is the number of strings and n is the average length. 
        Space is O(m × n) for storing all strings.
        */
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String cnts = getCounts(str);
            if(!map.containsKey(cnts)){
                map.put(cnts, new ArrayList<>());
            }
            map.get(cnts).add(str);
        }
        return new ArrayList<>(map.values());
        
    }
    private String getCounts(String str){
        int[] cnts = new int[26];
        for(char c : str.toCharArray()){
            cnts[c - 'a']++;
        }
        // return cnts.toString(); 这样返回的是内存地址
        return Arrays.toString(cnts); // 这样返回的是 "[1, 2, 0, .....]"
    }
}
