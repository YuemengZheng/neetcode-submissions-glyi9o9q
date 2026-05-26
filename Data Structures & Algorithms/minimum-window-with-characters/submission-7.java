class Solution {
    public String minWindow(String s, String t) {
        // move right
        // while share the same freq => move left to shrink until unvalid
        Map<Character, Integer> targetFreq = new HashMap<>();
        for(char c : t.toCharArray()){
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> curFreq = new HashMap<>();
        int valids = 0;
        int l = 0;
        int r = 0;
        int res = Integer.MAX_VALUE;
        int start = 0;
        while(r < s.length()){
            char addChar = s.charAt(r);
            if(targetFreq.containsKey(addChar)){
                curFreq.put(addChar, curFreq.getOrDefault(addChar, 0) + 1);
                if(curFreq.get(addChar) == targetFreq.get(addChar)){
                    valids++;
                }
            }
            r++;

            while(valids == targetFreq.size()){
                if(r - l < res){
                    res = r - l;
                    start = l;
                }
                char removeChar = s.charAt(l);
                if(targetFreq.containsKey(removeChar)){
                    if(targetFreq.get(removeChar) == curFreq.get(removeChar)){
                        valids--;
                    }
                    curFreq.put(removeChar, curFreq.get(removeChar) - 1);
                }
                l++;
            }
        }
        return res == Integer.MAX_VALUE? "" : s.substring(start, start + res);

    }
}
