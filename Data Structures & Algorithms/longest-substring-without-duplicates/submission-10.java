class Solution {
    public int lengthOfLongestSubstring(String s) {
        // use sliding window
        // move right to add new element to the window
        // when there is duplicate, move left until the window is valid
        // update the max length
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while(r < s.length()){
            char addChar = s.charAt(r);
            map.put(addChar, map.getOrDefault(addChar, 0) + 1);
            r++;

            while(map.get(addChar) > 1){
                char removeChar = s.charAt(l);
                map.put(removeChar, map.get(removeChar) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
}
