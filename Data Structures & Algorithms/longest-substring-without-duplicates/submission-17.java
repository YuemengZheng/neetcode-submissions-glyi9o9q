class Solution {
    public int lengthOfLongestSubstring(String s) {
        // use sliding window
        // when the window contains duplicates, move leftt to narrow down the window
        // otherwise move right to expand the window
        // finally return the global max
        int max = 0;
        int[] cnts = new int[256];
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            char cur = s.charAt(r++);
            cnts[cur]++;
            while(cnts[cur] > 1) {
                cnts[s.charAt(l++)]--;
            }

            max = Math.max(r - l, max);
        }
        return max;
    }
}
