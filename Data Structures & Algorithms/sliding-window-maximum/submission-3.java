class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        brute force 每个 window 都要重新找最大值，
        但当 window 向右移动一位时，其实有 k-1 个元素是重复的。

        关键问题是：这些旧元素是否还会影响未来 window 的最大值。

        如果新进入的元素更大，那么之前比它小的元素就不可能再成为最大值，可以直接删除；
        但如果旧元素更大，就需要保留，因为它仍然可能成为后续 window 的最大值。

        因此我们维护一个单调递减的 deque，
        只保留可能成为最大值的候选元素。
        这样 deque 的最左边始终就是当前 window 的最大值。
        */
        // ***** TIME: O(n), SPACE:O(n) *****
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // store index
        for(int i = 0; i < n; i++){
            // remove index put of current window
            while(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }
            // maintain decreasing deque
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            // add new index
            dq.offerLast(i);
            // record the cur max
            if(i >= k - 1){
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res; 
    }
}
