class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 用prefix和surfix去处理得到左边的乘积和右边的乘积
        // 最终把他们乘在一起就行了
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        int[] surfix = new int[nums.length];
        surfix[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            surfix[i] = surfix[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < nums.length; i++){
            prefix[i] *= surfix[i];
        }
        return prefix;
    }
}  
