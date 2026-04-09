class Solution {
    public int characterReplacement(String s, int k) {
        // 维护valid的窗口 ==> sliding window - maxFreq <= k
        // 当不满足条件，缩小窗口
        int[] cnt = new int[26];
        int l = 0;
        int maxFreq = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++){
            cnt[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, cnt[s.charAt(r) - 'A']);
            while((r - l + 1) - maxFreq > k){
                cnt[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
