class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while(map.get(cur) > 1) {
                char delete = s.charAt(l++);
                map.put(delete, map.get(delete) - 1);
            }
            max = Math.max(r - l + 1, max);
        }
        return max;
    }
}
