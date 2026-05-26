class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            if(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.removeLast();
            }

            dq.addLast(i);

            if(i >= k - 1){
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
