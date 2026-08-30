class Solution {
    public String minWindow(String s, String t) {
        // sliding window
        // when the window do not contains all the elements in the t, continus to expand the window
        // when the window is valid, try to move left to get the min valid window
        // return global min
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            char cur = s.charAt(r++);
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            if(need.containsKey(cur) && need.get(cur).equals(window.get(cur))) {
                valid++;
            }
            while(valid == need.size()) {
                if(r - l < len) {
                    start = l;
                    len = r - l;
                }
                cur = s.charAt(l++);
                if(need.containsKey(cur) && window.get(cur).equals(need.get(cur))) {
                    valid--;
                }
                window.put(cur, window.get(cur) - 1);
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
         
    }
}
