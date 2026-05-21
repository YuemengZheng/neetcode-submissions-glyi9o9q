class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        The brute force would be checking every pair, which is O(n²). 
        We can optimize with a HashMap 
        as we iterate, for each number we check if its complement has already been seen. 
        If yes, we return both indices. If not, we store the current number and its index. 
        This gives us O(n) time and O(n) space.
        */
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int find = target - nums[i];
            if(seen.containsKey(find)){
                return new int[]{seen.get(find), i};
            }
            seen.put(nums[i], i);
        }
        // this line should never be reached. I'm adding it to satisfy the compiler.
        return new int[]{-1, -1};
    }
}
