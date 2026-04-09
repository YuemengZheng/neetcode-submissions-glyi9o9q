class Solution {
    public int search(int[] nums, int target) {
        // ***** TIME: O(logn), SPACE:O(1) *****
        // we use binary search on the rotated sorted array
        // at each step, we determine which half is sorted
        // then we check whether the target is within that sorted half
        // and narrow down the search range accordingly
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < nums[right]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
