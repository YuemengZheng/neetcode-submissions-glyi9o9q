class Solution {
    public int search(int[] nums, int target) {
        // ***** TIME: O(logn), SPACE:O(1) *****
        // 首先确定nums[m]和nums[r]的关系，确定m的位置
        // 然后根据m的位置去划分左右，然后可以计算区间，根据target落在哪个区间，舍弃另一个区间
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l <= r){ // 寻具体target,不包含mid，所以用<=
            int mid = l + (r - l) / 2;
            if(target == nums[mid]){
                return mid;
            }
            // m的位置在左边
            if(nums[mid] > nums[r]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
