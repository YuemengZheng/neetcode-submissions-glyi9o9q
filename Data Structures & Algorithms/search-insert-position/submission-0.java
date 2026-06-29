class Solution {
    public int searchInsert(int[] nums, int target) {
        // 如果有target 直接返回target， 如没有target，我们返回的是第一个大于target的index
        // 因为求的是更大的，所以返回势必是l
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}