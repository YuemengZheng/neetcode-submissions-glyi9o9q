class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            String sub1 = helper(s, i, i);
            if(res.length() < sub1.length()) res = sub1;
            if(i + 1 < s.length()) {
                String sub2 = helper(s, i, i + 1);
                if(res.length() < sub2.length()) res = sub2;
            }
        }
        return res;
    }
    private String helper(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--; 
            j++;
        }
        return s.substring(i + 1, j);
    }
}
