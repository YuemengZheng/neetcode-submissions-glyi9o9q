class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        For each index, the result is the product of all elements on its left and right.
        I first store the prefix products in the result array,
        then traverse from right to left with a running suffix product and multiply it in.  
        */
        // ***** TIME: O(n), SPACE:O(1) *****
        // int n = nums.length;
        // int[] res = new int[n];
        // res[0] = 1;
        // for(int i = 1; i < n; i++){
        //     res[i] = res[i - 1] * nums[i - 1];
        // }
        // int suffix = 1;
        // for(int i = n - 1; i >= 0; i--){
        //     res[i] *= suffix;
        //     suffix *= nums[i];
        // }
        // return res;
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}  
