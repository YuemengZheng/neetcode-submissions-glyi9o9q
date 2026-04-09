class Solution {
    public boolean isPalindrome(String s) {
        // ***** TIME: O(n), SPACE:O(1) *****
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++; // l < r防止越界！！！
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}


