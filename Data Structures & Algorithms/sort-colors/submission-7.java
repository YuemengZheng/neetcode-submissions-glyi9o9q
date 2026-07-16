class Solution {
    public void sortColors(int[] nums) {
        // zero
        // cur
        // two
        // left part of the zero is zero
        // right part of the two is two
        // cur is the exploring point
        // left to cur is ones
        int zero = 0;
        int two = nums.length - 1;
        int cur = 0;
        while(cur <= two) {
            if(nums[cur] == 0) {
                swap(nums, cur++, zero++);
            }else if(nums[cur] == 1) {
                cur++;
            }else {
                swap(nums, cur, two--);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}