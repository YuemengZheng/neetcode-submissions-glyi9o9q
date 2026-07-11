class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
        For each index i, check if all strings have the same character at that position. 
        If not, return the prefix up to i
        */
        // t: m * n  s: 1
        String common = strs[0];
        for(int i = 0; i < common.length(); i++){
            for(String s : strs){
                if(i >= s.length() || common.charAt(i) != s.charAt(i)){
                    return common.substring(0, i);
                }
            }
        }
        return common;
    }
}