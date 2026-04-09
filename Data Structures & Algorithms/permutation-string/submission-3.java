class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        using sliding window with a fixed size 
        expand the window by moving the right pointer
        if the size of the window is too large, shrink from the left
        if the window contains all the characters in s1, return true
        */

        // ***** TIME: O(n), SPACE:O(1) *****
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
