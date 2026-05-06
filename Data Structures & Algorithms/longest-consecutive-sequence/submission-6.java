class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        I use a hash set for O(1) lookup.
        first put all the elements in the set
        for each element, if it is the start of a sequence,
        try to expand forward, otherwise, skip it
        this way, we can process each element at most once
        */
        // ***** TIME: O(n), SPACE:O(n) *****
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxLen = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int curLen = 1;
                int start = num;
                while(set.contains(++start)){
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
