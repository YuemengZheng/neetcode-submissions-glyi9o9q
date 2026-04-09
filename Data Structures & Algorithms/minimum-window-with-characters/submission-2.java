class Solution {
    public String minWindow(String s, String t) {
        /*
        Use a sliding window approach.
        Expand the window by moving the right pointer until it becomes valid.
        Once the window is valid, shrink it from the left as much as possible
        while maintaining validity.
        Keep updating the minimum length.
        */
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int l = 0, r = 0;
        int start = 0, len = Integer.MAX_VALUE;

        while(r < s.length()){
            char cur = s.charAt(r);
            if(need.containsKey(cur)){
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if(window.get(cur).equals(need.get(cur))){
                    valid++;
                }
            }
            r++;

            while(valid == need.size()){
                if(r - l < len){
                    start = l;
                    len = r - l;
                }

                cur = s.charAt(l);
                if(need.containsKey(cur)){
                    if(window.get(cur).equals(need.get(cur))){
                        valid--;
                    }
                    window.put(cur, window.get(cur) - 1);
                }
                l++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
