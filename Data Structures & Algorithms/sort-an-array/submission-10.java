class Solution {
    public int[] sortArray(int[] nums) {
        /*
        Both merge sort and heap sort achieve O(n log n) time. 
        The trade-off is space: merge sort uses O(n) extra space for the helper array, 
        while heap sort uses O(1) space since it sorts in place. 

        Heap Sort — High Level
        "I'll use heap sort. The idea is to first build a max-heap from the array, 
        so the largest element is at the root. 
        Then I repeatedly swap the root with the last element, shrink the heap by one, and re-heapify. 
        finally, the array is sorted in ascending order."


        "There are two phases:
        First, build the max-heap from the arr — I heapify from the last non-leaf node up to the root, 
        so every parent is larger than its children.

        Second, sort — I swap the root (the max) with the last element, reduce the heap size, 
        and heapify the new root back down. I repeat the process until the heap is empty."

        "For time, building the heap is O(n), and each of the n extractions takes O(log n) to re-heapify, so the total is O(n log n).
        For space, it's O(1) — everything is done in place
        */

        int n = nums.length;
        // Phase 1: build max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        // Phase 2: extract max one and re-heapify
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);        // move current max to the end
            heapify(nums, i, 0);     // restore heap on the reduced range
        }
        return nums;
    }

    private void heapify(int[] nums, int size, int i) {
        while(i < size){
            int largest = i;
            int l = i * 2 + 1;
            int r = i * 2 + 2;
            if(l < size && nums[l] > nums[largest]) largest = l;
            if(r < size && nums[r] > nums[largest]) largest = r;
            if(largest == i) break;
            swap(nums, largest, i);
            i = largest;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}