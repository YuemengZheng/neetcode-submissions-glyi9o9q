class Solution {
    public int[] productExceptSelf(int[] nums) {
        // use a arr to store the prefix product from left
        // use a running variable to store the cur surfix product from right
        // and for each position prefix * surfix is the answer
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}  
