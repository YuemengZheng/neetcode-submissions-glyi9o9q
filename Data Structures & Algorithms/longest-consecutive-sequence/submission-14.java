class Solution {
    public int longestConsecutive(int[] nums) {
        // use set to store all the nums met
        // loop through each element in the set
        // if there is smaller element in the set, we do not handle it
        // otherwise we find the start element, and we try to find the length
        // finally return the global len
        int len = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        for(int num : set) {
            if(set.contains(num - 1)) continue;
            int cur = 1;
            while(set.contains(num + 1)) {
                cur++;
                num += 1;
            }
            len = Math.max(len, cur);
        }
        return len;
    }
}
