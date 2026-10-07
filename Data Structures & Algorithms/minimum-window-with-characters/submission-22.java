class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int len = Integer.MAX_VALUE;
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int cnt = 0;
        Map<Character, Integer> have = new HashMap<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char add = s.charAt(r);
            have.put(add, have.getOrDefault(add, 0) + 1);
            if(have.get(add).equals(need.get(add))) cnt++;

            while(cnt == need.size()) {
                if(r - l + 1 < len) {
                    start = l;
                    len = r - l + 1;
                }
                char delete = s.charAt(l++);
                if(have.get(delete).equals(need.get(delete))) {
                    cnt--;
                }
                have.put(delete, have.get(delete) - 1);
                
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
