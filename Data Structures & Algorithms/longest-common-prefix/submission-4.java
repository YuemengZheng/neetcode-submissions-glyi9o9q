class Solution {
    public String longestCommonPrefix(String[] strs) {
        // compare each string and get the final common prefix
        // t: m * n  s: m
        String common = strs[0];
        for(String s : strs){
            if(common.length() == 0 || s.length() == 0){
                return "";
            }
            int i = 0;
            int j = 0;
            while(i < common.length() && j < s.length()){
                if(common.charAt(i) != s.charAt(j)){
                    common = common.substring(0, i);
                    break;
                }
                i++;
                j++;
            }
            common = common.substring(0, i);
        }
        return common;
    }
}