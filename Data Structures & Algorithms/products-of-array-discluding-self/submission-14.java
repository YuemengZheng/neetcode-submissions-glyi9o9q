class Solution {
    public int[] productExceptSelf(int[] nums) {
        // for each position, get the product of it's left and it's right
        // first use a arr, arr[i] -> product of it's left
        // use a running variable to record the product from right
        // get the final product from right to left

        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return res;
    }
}  
