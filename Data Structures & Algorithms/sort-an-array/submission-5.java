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

        mergeSort(0, nums.length - 1, nums, new int[nums.length]);
        return nums;
    }
    private void mergeSort(int start, int end, int[] nums, int[] helper){
        if(start == end) return;

        int mid = start + (end - start) / 2;
        mergeSort(start, mid, nums, helper);
        mergeSort(mid + 1, end, nums, helper);

        // mid 怎么分配， 因为我们采用的是mid = start + (end - start) / 2;
        // mid 偏左，所以我们应该把mid分配给左边，不然如果这里只有两个元素，[0, -1] 和 [0, 1]
        // 一个是空的，一个还是两个元素，并没有办法split the arr
        // copy the two sorted pieces into the helper arr
        // use two pointers pointing to the starts of both arr
        // always get the smaller one and fill into the nums
        merge(start, mid, end, nums, helper);
    }
    private void merge(int start, int mid, int end, int[] nums, int[] helper){
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
/*
1. High Level(开场)
"For this problem, I'll use merge sort. 
The idea is divide and conquer — I recursively split the array into two halves until each piece has only one element, 
then merge those sorted pieces back together. 

2. Main Steps(写代码前过一遍)
"Let me walk through the main steps. 
I'll use a recursive helper function that takes the start index, 
the end index, the array, and a helper array of the same size.
For the base case, if the range has only one element, I just return.
Otherwise, I find the middle index, recursively sort the left half and the right half, 
and then merge the two sorted halves together."

3. 边写主函数
"First, in the main function — if the array has one element or is empty, 
it's already sorted, so I return it directly. 
Otherwise, I call the recursive function over the whole range, 
and create the helper array here so I reuse the same one throughout."

4. 边写递归函数(mergeSort)
"In the recursive function, the base case is when start is greater than or equal to end 
— that means the range has at most one element, so I just return.
Otherwise, I compute the middle index. 
Then I recursively sort the left half from start to mid, and the right half from mid plus one to end. 
After both halves are sorted, I merge them."

5. 边写 merge 函数
"In the merge function, I first copy both halves into the helper array, so I have a stable reference to compare from.
Then I use two pointers — p1 starting at the left half, p2 at the right half. 
I compare the elements they point to, take the smaller one, and write it back into the original array. 
I move the corresponding pointer and the current position forward.
if left part has any elements left, I copy the remaining elements

6. 走例子(trace,如果面试官要)
"Let me trace through a small example with [3, 1, 2]. 
I split it into [3, 1] and [2]. 
The left part splits further into [3] and [1], which merge into [3, 1]. 
Now I merge [3, 1] with [2] — I compare 3 and 1, take 1; compare 3 and 2, take 2; then 3 is the only one left, 
so I add it. The final result is [1, 2, 3]."

7. 复杂度
"For time complexity, there are log n levels of splitting, and each level does O(n) work to merge, 
so the total is O(n log n). 
For space, it's O(n) because of the helper array I use for merging."
*/