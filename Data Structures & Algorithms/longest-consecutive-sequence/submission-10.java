class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        I use a hash set for O(1) lookup 
        and only start expanding from the beginning of a sequence, 
        so we avoid redundant work and achieve O(n) time
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
