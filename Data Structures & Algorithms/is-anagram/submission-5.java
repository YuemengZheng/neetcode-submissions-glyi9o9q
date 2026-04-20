class Solution {
    public boolean isAnagram(String s, String t) {
        // 
        if(s.length() != t.length()){
            return false;
        }
        int[] cnts = new int[26];
        for(char c : s.toCharArray()){
            cnts[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            if(cnts[c - 'a'] == 0){
                return false;
            }
            cnts[c - 'a']--;
        }
        return true;
    }
}
// time: O(2 * n)
// space: O(1)
