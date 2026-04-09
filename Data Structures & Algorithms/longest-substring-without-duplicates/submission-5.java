class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        We use a sliding window.
        We expand the window by moving the right pointer.
        If duplicates appear, we shrink the window from the left 
        to ensure all characters are unique.
        then keep updating the maximum length.
        */
        // ***** TIME: O(n), SPACE:O(k) *****
        // Space complexity is O(k), where k is the number of distinct characters.
        // Since the character set is limited to ASCII, so it can also be considered O(1).
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxLen = 0;
        while(r < s.length()){
            char cur = s.charAt(r);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            r++;
            
            while(map.get(cur) > 1){
                char remove = s.charAt(l);
                map.put(remove, map.get(remove) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
}

