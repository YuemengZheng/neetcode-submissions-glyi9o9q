class Solution {
    public void rotate(int[] nums, int k) {
        // use two pointers to reverse the entire arr first
        // then reverese the first k elements and the rest of the arr individually
        int size = nums.length;
        k = k % size;
        swap(nums, 0, size - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, size - 1);
    }
    private void swap(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}