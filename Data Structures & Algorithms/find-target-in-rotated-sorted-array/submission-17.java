class Solution {
    public int search(int[] nums, int target) {
        // use two pointers to find which half is sorted, and check if the target exist in that area
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < nums[r]) {
                if(target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }else{
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
