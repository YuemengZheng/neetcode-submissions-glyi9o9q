class Solution {
    public void reverseString(char[] s) {
        if(s.length <= 1) return;
        int l = 0;
        int r = s.length - 1;
        while(l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}