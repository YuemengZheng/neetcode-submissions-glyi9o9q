class Solution {
    public int rob(int[] nums) {
        /*
        For each house, we have two choices: rob or skip. 
        If we rob the current house, the previous house must be skipped. 
        If we skip, the previous house can be either robbed or skipped. 
        So we use dp to solve this problem，maintain two states at each step and take the max at the end.
        */
        int rob = nums[0];
        int notRob = 0;
        for(int i = 1; i < nums.length; i++){
            int curRob = notRob + nums[i];
            notRob = Math.max(rob, notRob);
            rob = curRob;
        }
        return Math.max(rob, notRob);
    }
}
