class Solution {
    public int countSubstrings(String s) {
        // treat each char as the center if the parlindrome, and try to expand
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            cnt += expand(s, i, i);
            cnt += expand(s, i, i + 1);
        }
        return cnt;
    }
    private int expand(String s, int i, int j) {
        int cnt = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            cnt++;
            i--;
            j++;
        }
        return cnt;
    }
}
