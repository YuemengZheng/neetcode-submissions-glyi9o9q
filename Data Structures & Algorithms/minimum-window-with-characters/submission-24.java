class Solution {
    public String minWindow(String s, String t) {
        // get the frequency of each element in the t
        // use sliding window
        // move right to add new elements
        // when the window contians all the elements needed
        // try to shrink from left to get the shortest len
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> have = new HashMap<>();
        int validCnt = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char add = s.charAt(r);
            have.put(add, have.getOrDefault(add, 0) + 1);
            if(have.get(add).equals(need.get(add))) validCnt++;

            while(validCnt == need.size()) {
                if(r - l + 1 < len) {
                    start = l;
                    len = r - l + 1;
                }
                char delete = s.charAt(l++);
                if(have.get(delete).equals(need.get(delete))) validCnt--;
                have.put(delete, have.get(delete) - 1);
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
