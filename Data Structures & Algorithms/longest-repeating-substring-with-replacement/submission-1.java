class Solution {
    public int characterReplacement(String s, int k) {
        // 维护valid的窗口 ==> sliding window - maxFreq <= k
        // 当不满足条件，缩小窗口
        // int[] cnt = new int[26];
        // int l = 0;
        // int maxFreq = 0;
        // int res = 0;
        // for(int r = 0; r < s.length(); r++){
        //     cnt[s.charAt(r) - 'A']++;
        //     maxFreq = Math.max(maxFreq, cnt[s.charAt(r) - 'A']); //maxFreq 只增不减？？不会影响结果么
        //     while((r - l + 1) - maxFreq > k){
        //         cnt[s.charAt(l) - 'A']--;
        //         l++;
        //     }
        //     res = Math.max(res, r - l + 1);
        // }
        // return res;

        // expand by moving right pointer
        // while the cnt > k, shrink the window by removing the left pointer
        // update the maxlen
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxFreq = 0;
        int res = 0;
        while(r < s.length()){
            char cur = s.charAt(r);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(cur));
            r++;

            while(r - l - maxFreq > k){
                cur = s.charAt(l);
                map.put(cur, map.get(cur) - 1);
                l++;
            }

            res = Math.max(res, r - l);
        }
        return res;
    }
}
