class Solution {
    public void sortColors(int[] nums) {
        // three pointers
        // tc: o(n)/ sc:o(1)
        if(nums.length <= 1) return;
        int p0 = 0;
        int p2 = nums.length - 1;
        int cur = 0;
        while(cur <= p2){
        // three caeses:
        // if cur = 1, move cur forward
            if(nums[cur] == 1){
                cur++;
            }
        // if cur = 0, swap p0 with cur, move both right
            else if(nums[cur] == 0){
                swap(cur, p0, nums);
                cur++;
                p0++;
            }
        // if cur = 2, swap it with p2, move p2 left
            else{
                swap(cur, p2, nums);
                p2--;
            }
        }
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
/*
nums1 = []
nums2 = [1]
nums3 = [0, 1, 1, 2]
            p0 p2
                  cur
*/