class Solution {
    public int rob(int[] nums) {
        // at each house, can rob or not
        // if we rob the i - 1, i can not been rob
        // if we do not rob the i - 1, we can choose to rob or skip cur house
        // finally, we choose the answer with great result
        // use dp
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
