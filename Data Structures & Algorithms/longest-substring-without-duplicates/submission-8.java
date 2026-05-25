class Solution {
    public int lengthOfLongestSubstring(String s) {
        // use sliding window
        // move right to add new element to the window
        // when there is duplicate, move left until the window is valid
        // update the max length
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int l = 0;
        for(int r = 0; r < arr.length; r++){
            char newChar = arr[r];
            while(set.contains(newChar)){
                set.remove(arr[l++]);
            }
            set.add(newChar);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen; 
    }
}
