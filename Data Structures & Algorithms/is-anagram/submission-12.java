class Solution {
    public boolean isAnagram(String s, String t) {
        // does s and t only consist of lowercase of english letters
        // i will first count the frequency of letters of each string
        // and then i will compare if they have the same frequency of letters
        // sc: m, tc: 1

        int lenS = s.length();
        int lenT = t.length();
        if(lenS != lenT) return false;

        int[] freqS = new int[26];
        int[] freqT = new int[26];
        for(int i = 0; i < lenS; i++){
            freqS[s.charAt(i) - 'a']++;
            freqT[t.charAt(i) - 'a']++;
        } 
        for(int i = 0; i < 26; i++){
            if(freqS[i] != freqT[i]){
                return false;
            }
        }
        return true;
    }
}
