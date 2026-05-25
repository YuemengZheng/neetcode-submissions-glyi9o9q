class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // fixed sized sliding window
        // move right pointer to add new character
        // if the size is greater than k, move left 
        // if the size is k and the substring in the window is a permutation of s1
        // return true
        Map<Character, Integer> targetFreq = new HashMap<>();
        for(char c : s1.toCharArray()){
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> curFreq = new HashMap<>();
        int l = 0;
        int r = 0;
        int valids = 0;
        while(r < s2.length()){
            char addChar = s2.charAt(r);
            if(targetFreq.containsKey(addChar)){
                curFreq.put(addChar, curFreq.getOrDefault(addChar, 0) + 1);
                if(curFreq.get(addChar) == targetFreq.get(addChar)){
                    valids++;
                }
            }
            r++;

            while(r - l > s1.length()){
                char removeChar = s2.charAt(l);
                if(targetFreq.containsKey(removeChar)){
                    if(curFreq.get(removeChar) == targetFreq.get(removeChar)){
                        valids--;
                    }
                    curFreq.put(removeChar, curFreq.get(removeChar) - 1);
                }
                l++;
            }

            if(r - l == s1.length() && valids == targetFreq.size()){
                return true;
            }
        }
        return false;
    }
}
