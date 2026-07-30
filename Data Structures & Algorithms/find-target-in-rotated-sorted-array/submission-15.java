class Solution {
    public int search(int[] nums, int target) {
        // get the mid element, try to define the target position
        // narrow down the area
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] <= nums[r]) {
                if(target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }else {
                if(target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
