class Solution {
    public boolean isAnagram(String s, String t) {
        // use an arr to cnt the frequency of each letter in the s
        // then decrease the cnt when loop through the letter in the t
        // when each freq of the letter is 0, return true, otherwise return false
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            freq[c - 'a']--;
            if(freq[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
