class Solution {
    public boolean search(int[] nums, int target) {
        // 通过nums[mid]和nums[r]的关系，找到有序的区间，我们看target在不在，然后narrow down
        // 因为这里面有重复元素，我们需要确定mid是不是落在重复元素上，这样我们不知道往哪里走只能r--
        
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] < nums[r]) {
                if(target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            // 因为会遇到重复元素，我们一旦遇到重复元素，就不知道应该往哪里挪动，所以r--
            }else if(nums[mid] == nums[r]){
                r--;
            }else{
                if(target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}