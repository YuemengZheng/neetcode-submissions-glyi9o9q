class Solution {
    public int[] sortArray(int[] nums) {
        // heap sort
        // heapfy the arr, so the parent element is greater or equal to it's children
        // we can always get the first element as the largest, swap it to the end of the arr, fix it
        // try to sink down unil the entil tree is valid again, and repeat the process untill we deal with all the elements
        for(int i = (nums.length - 1) / 2; i >= 0; i--) {
            sinkDown(nums, i, nums.length - 1);
        }
        for(int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            sinkDown(nums, 0, i - 1);
        }
        return nums;
    }

    private void sinkDown(int[] nums, int cur, int end) {
        while(cur <= end) {
            int largest = cur;
            int left = cur * 2 + 1;
            int right = cur * 2 + 2;
            if(left <= end && nums[left] > nums[largest]) largest = left;
            if(right <= end && nums[right] > nums[largest]) largest = right;
            if(largest == cur) break;
            swap(nums, cur, largest);
            cur = largest;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}