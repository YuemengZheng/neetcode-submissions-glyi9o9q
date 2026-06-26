class Solution {
    public boolean validPalindrome(String s) {
        // use two pointers to check from both ends
        // when we first meet not match, we try to skip the left element or right element and check if one of them can be palindrome
        // if so return true, else return false
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
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}