class Solution {
    public int search(int[] nums, int target) {
        // target不一定存在，所以我们每一个元素都检查
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            // 确认哪一边是sorted， 看target在不在sorted的那一侧
            if(nums[mid] == target) return mid;
            else if(nums[mid] < nums[r]) {
                if(target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if(target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
