class Solution {
    public int characterReplacement(String s, int k) {
        /*
        I'll use a sliding window approach. 
        I expand the window by moving the right pointer. 
        if the number of characters that need to be replaced exceeds k. 
        shrink from the left. 
        track the maximum window size throughout.
        */
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxFreq = 0;
        int res = 0;
        while(r < s.length()){
            char cur = s.charAt(r);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(cur));
            r++;

            // 目前的window是一定不可能valid
            // move left 一步window是可能valid，所以移动一步left，然后继续看情况
            // maxFreq不更新也没事，因为move right 也是一步一步
            // 如果下一步还是maxfreq的character那么就会更新maxfreq
            // 如果是另一个character，他反正也不会超过mostFreq,也不会影响我们maxlen的结果
            if(r - l - maxFreq > k){
                cur = s.charAt(l);
                map.put(cur, map.get(cur) - 1);
                l++;
            }

            res = Math.max(res, r - l);
        }
        return res;
    }
}
