class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for(int i = 0; i < common.length(); i++) {
            for(int j = 0; j < strs.length; j++) {
                if(strs[j].length() <= i || strs[j].charAt(i) != common.charAt(i)) {
                    return common.substring(0, i);
                }
            }
        }
        return common;
    }
}