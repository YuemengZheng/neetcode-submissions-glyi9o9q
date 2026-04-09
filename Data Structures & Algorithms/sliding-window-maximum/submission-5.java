class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        for the brute force, 每一个k大的范围内，都要从头到尾扫描，找最大，所以是n*k
        中间有很多重复的工作，我们可以通过一个单调递减栈去实现n的时间复杂度
        每当我们要加入一个元素的时候，看看有没有过期的不再k范围内的，从前面pop out
        然后看看有没有比当前元素小的值，他们不可能再成为答案了，也直接pop out from end
        然后加入新的元素，当前的max就是queue最前头的元素
        */
        // ***** TIME: O(n), SPACE:O(n) *****
        // int n = nums.length;
        // int[] res = new int[n - k + 1];
        // Deque<Integer> dq = new ArrayDeque<>(); // store index
        // for(int i = 0; i < n; i++){
        //     // remove index put of current window
        //     while(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
        //         dq.pollFirst();
        //     }
        //     // maintain decreasing deque
        //     while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
        //         dq.pollLast();
        //     }
        //     // add new index
        //     dq.offerLast(i);
        //     // record the cur max
        //     if(i >= k - 1){
        //         res[i - k + 1] = nums[dq.peekFirst()];
        //     }
        // }
        // return res; 
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k - 1){
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
