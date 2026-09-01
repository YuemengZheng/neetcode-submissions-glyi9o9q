class Solution {
    public int rob(int[] nums) {
        // treat it as a linear problem
        // we can choose to skip the first, or skip the last one to use dp to get the res
        // Time: O(n） Space: O(1)
        if(nums.length == 1) return nums[0];
        int skipLast = getRob(nums, 0, nums.length - 2);
        int skipFirst = getRob(nums, 1, nums.length - 1);
        return Math.max(skipLast, skipFirst);
    }
    private int getRob(int[] nums, int start, int end) {
        int rob = nums[start];
        int skip = 0;
        for(int i = start + 1; i <= end; i++) {
            int curRob = skip + nums[i];
            skip = Math.max(skip, rob);
            rob = curRob;
        }
        return Math.max(rob, skip);
    }
}
