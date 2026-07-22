class Solution {
    public boolean isAnagram(String s, String t) {
        /*
         use a fixed-size array of 26 to count character frequencies. 
         I increment counts for the first string and decrement for the second. 
         If all counts end up at zero, they're anagrams. 
         Time is O(n), space is O(1) since the array size is constant
        */

        if(s.length() != t.length()) return false;

        int[] cnts = new int[26];
        for(char c : s.toCharArray()){
            cnts[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            cnts[c - 'a']--;
        }
        
        for(int cnt : cnts){
            if(cnt != 0) return false;
        }
        return true;
    }
}
