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
        // i <= n/2 - 1 在 n 是完整长度时可以用,但排序阶段 n 变小了,这个公式就不准确了
        // 所以是有左节点我们可以继续， 或者写成 i < n, 但是左右节点都需要判断
        // while(2 * i + 1 < n){
        //     int child = 2 * i + 1;
        //     if(child + 1 < n && nums[child + 1] > nums[child]){
        //         child++;
        //     }
        //     if(nums[i] >= nums[child]) break;
        //     swap(nums, i, child);
        //     i = child;
        // }
        while(i < n){
            int largest = i;
            int l = i * 2 + 1;
            int r = i * 2 + 2;
            if(l < n && nums[l] > nums[largest]) largest = l;
            if(r < n && nums[r] > nums[largest]) largest = r;
            if(largest == i) break;
            swap(nums, largest, i);
            i = largest;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}