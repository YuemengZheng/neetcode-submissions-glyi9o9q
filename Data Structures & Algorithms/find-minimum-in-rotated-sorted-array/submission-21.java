class Solution {
    public int findMin(int[] nums) {
        // use two pointers -> middle element to find which half is sorted
        // try to find which half must not contains min element and diuqi
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
