class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        // backtracking
        // gloabl variable => res
        // helper function: inputs => nusm, startindex, xor
        // for each step: 
        // res += xor
        // iterate through the arr starts from the startidnex, try to xor the element, recurse
        // return res  
        backtracking(nums, 0, 0);
        return res;
    }
    private void backtracking(int[] nums, int start, int xor){
        res += xor;
        for(int i = start; i < nums.length; i++){
            int temp = xor;
            xor ^= nums[i];
            backtracking(nums, i + 1, xor);
            xor = temp;
        }
    }
}
// tc : 2 ^ n, n
// [1, 2]
/*  
        []
     [1]  [2]
   [1, 2] 
*/
