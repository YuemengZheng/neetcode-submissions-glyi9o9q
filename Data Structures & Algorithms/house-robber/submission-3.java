class Solution {
    public int rob(int[] nums) {
        // dp[i] represents the most total money we can rob at the index i
        // for each i, if i - 1 are not robed -> we have two choose, else we cannot rob
        // base case 
        // dp[0] = nums[0]
        // dp[1] = max(nums[0], nums[1])
        // dp[i] = rob - dp[i - 1] |  max(not rob dp[i - 1] + nums[i], not robed dp[i - 1]))
        // finally return max of dp[i] robed or not robbed
        int rob = nums[0];
        int skip = 0;
        for(int i = 1; i < nums.length; i++) {
            int curRob = skip + nums[i];
            skip = Math.max(rob, skip);
            rob = curRob;
        }
        return Math.max(rob, skip);
    }
}
