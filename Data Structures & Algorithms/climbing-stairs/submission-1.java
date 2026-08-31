class Solution {
    public int climbStairs(int n) {
        // dp[i] represents how many methods we need to take to reach the stairs i
        // initialize dp[1] = 1, dp[2] = 2
        // dp[i] = dp[i - 1] + dp[i - 2]
        // return dp[n + 1]
        if(n <= 2) return n;
        int onestep = 1;
        int twosteps = 2;
        int total = 0;
        for(int i = 3; i <= n; i++) {
            total = onestep + twosteps;
            if(i % 2 == 1) onestep = total;
            else twosteps = total;
        }
        return total;
    }
}
