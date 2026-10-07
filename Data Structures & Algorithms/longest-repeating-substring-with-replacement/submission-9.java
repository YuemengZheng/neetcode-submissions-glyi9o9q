class Solution {
    public int characterReplacement(String s, int k) {
        // use hashmap to keep track of the frequency of each element
        // use a running mostFreq to store the most frequency seen so far
        // for each element, update the map, if the freq is grater than mostFreq, this can get a heigher res
        // otherwise just keep the most freq as the real most freq
        Map<Character, Integer> map = new HashMap<>();
        int mostFreq = 0; // we always use mostFreq to represent the real most freq cause that will not influence the final res
        int res = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char add = s.charAt(r);
            map.put(add, map.getOrDefault(add, 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(add));

            if(r - l + 1 - mostFreq <= k) res = Math.max(res, r - l + 1);
            else {
                char delete = s.charAt(l++);
                map.put(delete, map.get(delete) - 1);
            }
        }
        return res;
    }
}
