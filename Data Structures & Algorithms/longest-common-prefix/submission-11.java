class Solution {
    public String longestCommonPrefix(String[] strs) {
        // use two pointers to compare each pair of string get the common prefix
        int common = strs[0].length();
        String first = strs[0];
        for(int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            int j = 0;
            while(j < common && j < cur.length() && first.charAt(j) == cur.charAt(j)) {
                j++;
            }
            common = j;
            if(common == 0) {
                return "";
            }
        }
        return first.substring(0, common);
    }
}