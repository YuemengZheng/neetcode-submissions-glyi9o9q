class Solution {
    public String minWindow(String s, String t) {
        // sliding window
        // when the window do not contains all the elements in the t, continus to expand the window
        // when the window is valid, try to move left to get the min valid window
        // return global min
        Map<Character, Integer> target = new HashMap<>();
        for(char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> freq = new HashMap<>();
        int start = 0;
        int cnts = 0;
        int res = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            char cur = s.charAt(r++);
            freq.put(cur, freq.getOrDefault(cur, 0) + 1);
            if(target.containsKey(cur) && target.get(cur).equals(freq.get(cur))) {
                cnts++;
            }
            while(cnts == target.size()) {
                if(r - l < res) {
                    start = l;
                    res = r - l;
                }
                cur = s.charAt(l++);
                if(target.containsKey(cur) && target.get(cur).equals(freq.get(cur))) {
                    cnts--;
                }
                freq.put(cur, freq.get(cur) - 1);
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
    }
}
