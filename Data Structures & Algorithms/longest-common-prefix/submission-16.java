class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
        Goal:
        "Find the longest common prefix among all strings."

        High level:
        "Use the first string as the reference. 
        Compare it with each subsequent string character by character, 
        and keep updating the common prefix length."

        Main steps:
        "Initialize common as the length of the first string.
        For each subsequent string, compare it with the first string up to the current common length. 
        When a mismatch is found, update common to the current index.
        If common becomes 0, return empty string immediately.
        Finally return the substring of the first string with length common."

        TC & SC:
        "Time complexity is O(n * m) where n is the number of strings 
        and m is the length of the shortest string. 
        Space complexity is O(1) since we only use one substring at the end."
        */
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