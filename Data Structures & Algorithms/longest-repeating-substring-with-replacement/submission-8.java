class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window
        // keep track of the most freq element, when the most freq is greater, update the most freq
        // when the cnt of others is within k, update the max
        // otherwise, try to move left and keep the window size
        int max = 0;
        int[] cnts = new int[26];
        int mostFreq = 0;
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            char cur = s.charAt(r++);

            if(++cnts[cur - 'A'] > mostFreq) {
                mostFreq = cnts[cur - 'A'];
            }

            if(r - l - mostFreq <= k) {
                max = Math.max(max, r - l);
            }else {
                cnts[s.charAt(l++) - 'A']--;
            }
        }
        return max;
    }
}
