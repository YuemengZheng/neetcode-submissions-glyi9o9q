class Solution {
    public int lengthOfLongestSubstring(String s) {
        // use sliding window
        // when the window contains duplicates, move leftt to narrow down the window
        // otherwise move right to expand the window
        // finally return the global max
        int max = 0;
        int[] cnts = new int[256];
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            cnts[s.charAt(r)]++;
            while(cnts[s.charAt(r)] > 1) {
                cnts[s.charAt(l++)]--;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
