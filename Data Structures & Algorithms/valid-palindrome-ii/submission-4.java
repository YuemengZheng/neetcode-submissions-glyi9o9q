class Solution {
    public boolean validPalindrome(String s) {
        /*
        I'll use two pointers from both ends. 
        When characters match, I move inward. 
        The first time they don't match, I have one deletion to use — 
        so I check whether skipping the left character or skipping the right character leaves a palindrome. 
        If either works, return true; otherwise false."
        */
        int l = 0; int r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return isPalindrome(l + 1, r, s) || isPalindrome(l, r - 1, s);
            }
            l++;
            r--;
        }
        return true; 
    }
    private boolean isPalindrome(int l, int r, String s) {
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}