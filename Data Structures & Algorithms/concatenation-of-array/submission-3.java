class Solution {
    public int[] getConcatenation(int[] nums) {
        // For the ans arr, ans at index i equals nums at index i mod n
        int len = nums.length;
        int[] ans = new int[2 * len];
        for(int i = 0; i < ans.length; i++){
            ans[i] = nums[i % len];
        }
        return ans;
    }
}