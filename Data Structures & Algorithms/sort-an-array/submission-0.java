class Solution {
    public int[] sortArray(int[] nums) {
        /*
        Merge SortO(n log n) 稳定O(n)✅ 最推荐,逻辑清晰
        Quick Sort平均 O(n log n),最坏 O(n²)O(log n)⚠️ 有大量重复会 TLE,要优化
        Heap SortO(n log n) 稳定O(1)✅ 空间最优


        Merge Sort
        for this problem, i will use merge sort
        recursively split the arr into two halves until each piece has only one element
        and then merge those sorted pieces back together

        steps：
        use a helper recursion fucntion
        which takes four inputs, start and end index and the nums arr and a empty helper arr with the same size
        for the base case, if there is only one element, return it
        otherwise, find the middle index and recursively sort the lefy half and right half
        and then merge them together
        */
        if(nums.length <= 1) return nums;

        recursion(0, nums.length - 1, nums, new int[nums.length]);
        return nums;
    }
    private void recursion(int start, int end, int[] nums, int[] helper){
        if(start == end) return;

        int mid = start + (end - start) / 2;
        recursion(start, mid, nums, helper);
        recursion(mid + 1, end, nums, helper);
        // copy the two sorted pieces into the helper arr
        // use two pointers pointing to the starts of both arr
        // always get the smaller one and fill into the nums
        for(int i = start; i <= end; i++){
            helper[i] = nums[i];
        }

        int p1 = start;
        int p2 = mid + 1;
        int cur = start;
        while(p1 <= mid && p2 <= end){
            if(helper[p1] < helper[p2]){
                nums[cur++] = helper[p1++];
            }else{
                nums[cur++] = helper[p2++];
            }
        }
        while(p1 <= mid){
            nums[cur++] = helper[p1++];
        }
    }
}