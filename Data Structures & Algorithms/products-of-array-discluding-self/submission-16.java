class Solution {
    public int[] productExceptSelf(int[] nums) {
        //  

        /*
         High Level: I use prefix and suffix products to solve this problem.
         Quick walkthrough:
            In the first pass, I store the left product for each index in the result array.
            Then in the second pass, I iterate from right to left and multiply by the running right product.
            This way, each position gets both left and right products.
        */
        // ***** TIME: O(n), SPACE:O(1) *****
        int[] res = new int[nums.length];

        // prefix
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }

        // suffix
        int suffix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}  
