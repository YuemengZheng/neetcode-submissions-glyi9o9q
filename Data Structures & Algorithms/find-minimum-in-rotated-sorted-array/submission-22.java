class Solution {
    public int findMin(int[] nums) {
        // there can be two parts of sorted arr
        // first find the mid exists in which half by compare the right most element with the mid
        // narrow down the searching area
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
