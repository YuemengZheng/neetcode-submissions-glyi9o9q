class Solution {
    public int findMin(int[] nums) {
        /*
        We use binary search to find the minimum in a rotated sorted array.
        We compare the middle element with the rightmost element to determine 
        which side is sorted in ascending order, based on that, we narrow down the search range.
        */
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
