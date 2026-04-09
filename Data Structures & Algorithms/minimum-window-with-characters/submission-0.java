class Solution {
    public String minWindow(String s, String t) {
        // sliding window
        // 扩张的时候是 valid letter <= t.length
        // 当符合条件收缩到不满足条件
        int sLen = s.length();
        int tLen = t.length();
        int[] cnts = new int[256];
        for(char c : t.toCharArray()){
            cnts[c]--;
        }
        int validCnt = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        for(int l = 0, r = 0; r < sLen; r++){
            if(cnts[s.charAt(r)]++ < 0){
                validCnt++;
            }
            while(validCnt == tLen && cnts[s.charAt(l)] > 0){
                cnts[s.charAt(l++)]--;
            }
            if(validCnt == tLen && r - l + 1 < len){
                len = r - l + 1;
                start = l;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
