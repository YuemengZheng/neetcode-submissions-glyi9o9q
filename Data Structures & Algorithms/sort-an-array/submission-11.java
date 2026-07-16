class Solution {
    public int[] sortArray(int[] nums) {
        // merge sort
        // use dfs, at each step, divide the arr into two parts, until there is only one element
        // sort them individually and merge back 
        dfs(0, nums.length - 1, nums, new int[nums.length]);
        return nums;
    }
    // dfs takes start index, end index, nums, a reference arr, return the sorted arr
    private void dfs(int start, int end, int[] nums, int[] copy) {
        if(start == end) return;

        int mid = start + (end - start) / 2;
        dfs(start, mid, nums, copy);
        dfs(mid + 1, end, nums, copy);
        merge(start, mid, end, nums, copy);
    }
    private void merge(int start, int mid, int end, int[] nums, int[] copy) {
        for(int i = start; i <= end; i++) {
            copy[i] = nums[i];
        }
        int i = start;
        int j = mid + 1;
        int cur = start;
        while(i <= mid && j <= end) {
            if(copy[i] <= copy[j]) {
                nums[cur++] = copy[i++];
            }else{
                nums[cur++] = copy[j++];
            }
        }
        while(i <= mid) {
            nums[cur++] = copy[i++];
        }
    }

}