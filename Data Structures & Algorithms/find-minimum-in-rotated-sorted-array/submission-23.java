class Solution {
    public int findMin(int[] nums) {
        // 找到最小数
        // l < r用于最后只剩一个数字了 那个数字就是答案
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
