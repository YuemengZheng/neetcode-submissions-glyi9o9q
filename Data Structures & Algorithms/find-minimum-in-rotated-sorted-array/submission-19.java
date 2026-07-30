class Solution {
    public int findMin(int[] nums) {
        // at least two sorted arr
        // use bst, every time get thee mid element, and compare with right most element
        // if it is larger, it can not be the answer, so move l = mid + 1
        // else move right = mid
        // return l
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] <= nums[r]) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
