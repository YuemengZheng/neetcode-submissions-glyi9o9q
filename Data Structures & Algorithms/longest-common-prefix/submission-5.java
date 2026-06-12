class Solution {
    public String longestCommonPrefix(String[] strs) {
        // compare each string and get the final common prefix
        // t: m * n  s: n
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