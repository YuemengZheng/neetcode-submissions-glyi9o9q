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
        int mostFreq = 0; 
        int res = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char add = s.charAt(r);
            map.put(add, map.getOrDefault(add, 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(add));

            if(r - l + 1 - mostFreq <= k) res = Math.max(res, r - l + 1);
            else {
                char delete = s.charAt(l++);
                map.put(delete, map.get(delete) - 1);
            }
        }
        return res;
    }
}
