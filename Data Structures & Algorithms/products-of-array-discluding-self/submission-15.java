class Solution {
    public int[] productExceptSelf(int[] nums) {
        // for each position, get the product of it's left and it's right
        // first use a arr, arr[i] -> product of it's left
        // use a running variable to record the product from right
        // get the final product from right to left
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int[] sufix = new int[n];
        sufix[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            sufix[i] = sufix[i + 1] * nums[i + 1];
        }

        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = prefix[i] * sufix[i];
        }
        return res;
    }
}  
