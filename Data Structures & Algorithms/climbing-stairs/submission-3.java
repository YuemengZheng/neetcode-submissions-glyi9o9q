class Solution {
    public int climbStairs(int n) {
        // dp[i] represents how many methods we need to take to reach the stairs i
        // initialize dp[1] = 1, dp[2] = 2
        // dp[i] = dp[i - 1] + dp[i - 2]
        // return dp[n + 1]
        if(n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
