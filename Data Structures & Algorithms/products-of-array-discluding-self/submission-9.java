class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
         Store the left product directly in the result array first. 
         Then iterate from right to left, maintaining a running right product variable. 
         For each position, multiply the element by the right product, 
         then update the right product for the next iteration. O(n) time, O(1) 
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
