class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        // 没有截断
        if(nums[0] < nums[len - 1]){
            return nums[0];
        }

        // 截断(利用两边的单调性)
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            // 落在右边
            if(nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
