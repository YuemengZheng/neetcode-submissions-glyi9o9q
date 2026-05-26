class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 使用decreasing queue to slove this problem
        // 先把k - 1个元素放进queue
        // 后续每加入一个新的num之前，我们都看下把前面小的nums都pop
        // 把不在范围内的元素pop
        // 然后加入元素，取第一个作当前range的max
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            // 把之前小的都pop
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            // 把不在范围的pop
            if(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }
            // 加入这个index
            dq.offerLast(i);
            // 如果index >= k - 1 => 取得一下当前range的max
            if(i >= k - 1){
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
