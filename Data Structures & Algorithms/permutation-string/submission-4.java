class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        We use a sliding window with a fixed size.
        We expand the window by moving the right pointer.
        If the window becomes too large, we shrink it from the left.
        If the window has the same size as s1 
        and matches the required character frequencies, we return true.
        */

        // ***** TIME: O(n + m), SPACE:O(k) *****
        Map<Character, Integer> need = new HashMap<>();
        for(char c : s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int l = 0, r = 0;
        while(r < s2.length()){
            char cur = s2.charAt(r);
            if(need.containsKey(cur)){
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if(need.get(cur).equals(window.get(cur))){
                    valid++;
                }
            }
            r++;

            if(r - l > s1.length()){
                cur = s2.charAt(l);
                if(need.containsKey(cur)){
                    if(need.get(cur).equals(window.get(cur))){
                        valid--;
                    }
                    window.put(cur, window.get(cur) - 1);
                }
                l++;
            }

            if(valid == need.size()){
                return true;
            }
        }
        return false;
    }
}
