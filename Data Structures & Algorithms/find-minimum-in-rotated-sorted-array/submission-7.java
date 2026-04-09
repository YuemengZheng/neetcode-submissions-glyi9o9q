class Solution {
    public int findMin(int[] nums) {
        /*
        We use binary search to find the minimum in a rotated sorted array.
        We compare the middle element with the rightmost element to determine 
        which side contains the minimum.
        Based on that, we narrow down the search range.
        */

        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= nums[right]){
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            }else if(nums[mid] > nums[right]){
                left = mid + 1;
            }
        }
        return res;
    }
}
