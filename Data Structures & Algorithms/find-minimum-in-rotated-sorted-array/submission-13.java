class Solution {
    public int findMin(int[] nums) {
        /*
        We use binary search to find the minimum in a rotated sorted array.
        We compare the middle element with the rightmost element to determine 
        which side contains the minimum.
        Based on that, we narrow down the search range.
        */

        int left = 0, right = nums.length - 1;
        while(left < right){
            if (nums[left] < nums[right]) return nums[left];
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
