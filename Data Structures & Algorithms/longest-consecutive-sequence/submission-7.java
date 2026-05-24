class Solution {
    public int longestConsecutive(int[] nums) {
        // original order is not important
        // use a set to store all the elements, and find all the possible the start 
        // and record the length of consecutive sequence with that start
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int res = 0;
        for(int num : nums){
            if(!set.contains(num - 1)){
                int curLen = 0;
                while(set.contains(num)){
                    curLen++;
                    num++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
