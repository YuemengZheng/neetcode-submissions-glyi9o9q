class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window
        // move right to add new character
        // when len - mostfreq > k, move left, to let the sliding window be potantially valid
        // update the maxlen
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int mostFreq = 0;
        int l = 0;
        int r = 0;
        while(r < s.length()){
            char addChar = s.charAt(r);
            map.put(addChar, map.getOrDefault(addChar, 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(addChar));
            r++;

            if(r - l - mostFreq > k){
                char removeChar = s.charAt(l);
                map.put(removeChar, map.get(removeChar) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
}
