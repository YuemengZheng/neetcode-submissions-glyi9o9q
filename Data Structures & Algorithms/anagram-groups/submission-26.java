class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        only lowercase
        use a character count array with 26 length, convert into a string 
        */
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String freq = getCount(s);
            map.computeIfAbsent(freq, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
    private String getCount(String s){
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        return Arrays.toString(arr);
    }
}
