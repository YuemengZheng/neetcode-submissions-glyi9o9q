class Solution {
    public int characterReplacement(String s, int k) {
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

            // 不理解为什么这样写
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
