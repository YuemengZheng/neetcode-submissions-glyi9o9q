class Solution {
    public int rob(int[] nums) {
        /*
        Since the first and last houses are neighbors, they can't both be robbed. 
        So I split it into two linear problems: one including the first house but excluding the last, 
        and one excluding the first but including the last. Take the max of the two
        */
        if(nums.length == 1) return nums[0];
        int chooseFirst = dfs(nums, 0, nums.length - 2);
        int chooseLast = dfs(nums, 1, nums.length - 1);
        return chooseFirst > chooseLast ? chooseFirst : chooseLast;
    }
    private int dfs(int[] nums, int start, int end){
        int rob = nums[start];
        int notRob = 0;
        for(int i = start + 1; i <= end; i++){
            int newRob = nums[i] + notRob;
            notRob = Math.max(rob, notRob);
            rob = newRob;
        }
        return Math.max(rob, notRob);
    }
}
