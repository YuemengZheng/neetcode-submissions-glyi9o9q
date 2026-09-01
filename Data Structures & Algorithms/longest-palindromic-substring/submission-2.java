class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > maxLen) {
                start = i - (len - 1) / 2; // ****ERROR1****
                maxLen = len;
            }
        }
        return s.substring(start, start + maxLen);
    }
    private int expand(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) { // ****ERROR2****
            i--;
            j++;
        }
        return j - i - 1;// ****ERROR3****
    }
}
