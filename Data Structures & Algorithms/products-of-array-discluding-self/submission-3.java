class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        For each position, the result is the product of all numbers to its left 
        multiplied by the product of all numbers to its right.
        So we can solve this problem using prefix and suffix products.
        Instead of using two separate arrays, we store the prefix product directly in the result array.
        Then we traverse the array from right to left while maintaining a running suffix product and multiply it into the result.
        */
        // ***** TIME: O(n), SPACE:O(1) *****
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
