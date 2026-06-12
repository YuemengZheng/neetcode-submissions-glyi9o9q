class Solution {
    public int[] getConcatenation(int[] nums) {
        // ans[i] = nums[i % n]
        int len = nums.length;
        int[] ans = new int[2 * len];
        for(int i = 0; i < ans.length; i++){
            ans[i] = nums[i % len];
        }
        return ans;
    }
}