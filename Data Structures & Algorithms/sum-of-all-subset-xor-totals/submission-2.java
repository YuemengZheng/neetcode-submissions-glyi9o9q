class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        /*
        For this problem, our goal is to get the total sum of XOR totals for each subset. 
        My idea is to use backtracking to enumerate all the subsets and calculate their XOR.

        For the recursion tree, each level represents trying each possible start index, and we'll have n levels.

        For the main steps, I'll use a helper function with inputs: the array, the start index, 
        and the current XOR value. At each level, first I add the current XOR to the result. 
        Then I iterate through each element and recursively calculate the XOR with that element. 
        This way, we explore all possible subsets.

        In the recursion, the curXOR represents the XOR value of the current path, which is a subset. 
        We use res to accumulate the XOR values of all subsets."
        */
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