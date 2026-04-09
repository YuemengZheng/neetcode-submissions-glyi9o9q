class Solution {
    public int search(int[] nums, int target) {
        // ***** TIME: O(logn), SPACE:O(1) *****
        // use binary search
        // 首先找到middle element，check 是不是target
        // 通过middle element和right most element的比较，找到sorted half
        // check if the target在sorted half，如果在我们继续探索这个half
        // 如果不在，我们探索另一half
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
