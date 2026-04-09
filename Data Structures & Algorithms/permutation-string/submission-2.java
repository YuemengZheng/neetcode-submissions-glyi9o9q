class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // sliding window valid => fix length && cnt 
        // ***** TIME: O(n), SPACE:O(1) *****
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[] cnts = new int[26];
        for(char c : s1.toCharArray()){
            cnts[c - 'a']--;
        }
        int validCnt = 0;
        for(int l = 0, r = 0; r < s2.length(); r++){
            if(cnts[s2.charAt(r) - 'a']++ < 0){ // ！！still need this character
                validCnt++;
            }
            while(r - l + 1 > s1Len){
                if(--cnts[s2.charAt(l) - 'a'] < 0){// ！！still need this character
                    validCnt--;
                }
                l++;
            }
            if(validCnt == s1Len){
                return true;
            }
        }
        return false;
    }
}
