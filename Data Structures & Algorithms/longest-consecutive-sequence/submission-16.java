class Solution {
    public int longestConsecutive(int[] nums) {
        // the longgest consecutive sequence, that the order of each element do not matter
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        // cause we wanna find the smallest start and try to move forward to find the longest sequence
        // if num - 1 exist in the set, skip it
        // if not, we will try to expand the sequence
        int res = 0;
        for(int num : set) {
            if(set.contains(num - 1)) continue;
            int cnt = 0;
            while(set.contains(num)) {
                cnt++;
                num++;
            } 
            res = Math.max(res, cnt);
        }
        return res;
    }
}
