class Solution {
    public int[] sortArray(int[] nums) {
        // heap sort
        int n = nums.length;
        // heapify
        for(int i = n / 2 - 1; i >= 0; i--){
            siftDown(nums, n, i);
        }

        // sort the arr by always get the largest element and swap to the end of the arr, fix that position
        // siftDown from the root
        int cur = n - 1;
        while(cur > 0){
            swap(nums, cur, 0);
            siftDown(nums, cur, 0); // 被固定的elements都不能动了
            cur--;// cur要被fixed
        }
        return nums;
    }
    private void siftDown(int[] nums, int n, int i){
        while(2 * i + 1 < n){
            int child = 2 * i + 1;
            if(child + 1 < n && nums[child + 1] > nums[child]){
                child++;
            }
            if(nums[i] >= nums[child]) break;
            swap(nums, i, child);
            i = child;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}