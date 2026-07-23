class Solution {
    public boolean isPalindrome(String s) {
        /*
        For this problem I will use two pointers, 
        starting from both ends of the string and moving inward. 
        At each step, I'll skip over non-alphanumeric characters on both sides, 
        then compare the alphanumeric characters in lowercase. If any don't match, 
        I return false. When the pointers meet, I return true
        */
        // ***** TIME: O(n), SPACE:O(1) *****
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(Character.toLowerCase(s.charAt(l)) != 
            Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}


