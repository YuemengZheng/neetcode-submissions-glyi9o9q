class Solution {
    public int search(int[] nums, int target) {
        // ***** TIME: O(logn), SPACE:O(1) *****
        int l = 0, r = nums.length - 1;
        while(l <= r){// 条件
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }
}
