class Solution {
    public int search(int[] nums, int target) {
        // nums[mid] == target return 
        // mid 在右part
            // target < nums[mid], right = mid - 1
            //  >, left = mid + 1
        // mid 在左part
            // mid < target, l = mid + 1
            // mid > targt, right = mid - 1
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else{
                if(nums[mid] <= nums[right]){
                    if(nums[mid] < target && target <= nums[right]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }else{
                    if(nums[left] <= target && target < nums[mid]){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
