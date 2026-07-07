class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        // 对于每一个subset进行xor
        // 2^n | n
        backtracking(nums, 0, 0);
        return res;
    }
    private void backtracking(int[] nums, int start, int xor){
        res += xor;
        for(int i = start; i < nums.length; i++){
            backtracking(nums, i + 1, xor ^ nums[i]);
        }
    }
}