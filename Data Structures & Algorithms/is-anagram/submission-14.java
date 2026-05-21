class Solution {
    public boolean isAnagram(String s, String t) {
        // does s and t only consist of lowercase of english letters
        // i will first count the frequency of letters of each string
        // and then i will compare if they have the same frequency of letters
        // sc: m, tc: 1

        if(s.length() != t.length()) return false;

        int[] cnts = new int[26];
        for(char c : s.toCharArray()){
            cnts[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            cnts[c - 'a']--;
        }

        for(int cnt : cnts){
            if(cnt != 0){
                return false;
            }
        }
        return true;
    }
}
