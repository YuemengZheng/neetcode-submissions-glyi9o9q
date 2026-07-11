class Solution {
    public String longestCommonPrefix(String[] strs) {
        // use two pointers to compare each pair of string get the common prefix
        int common = strs[0].length();
        for(int i = 1; i < strs.length; i++) {
            String prev = strs[i - 1];
            String cur = strs[i];
            int x = 0;
            int y = 0;
            while(x < common && y < cur.length()) {
                if(prev.charAt(x) != cur.charAt(y)){
                    break;
                }
                x++;
                y++;
            }
            common = x;
            if(common == 0) {
                return "";
            }
        }
        return strs[0].substring(0, common);
    }
}