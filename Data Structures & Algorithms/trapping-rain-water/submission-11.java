class Solution {
    public int trap(int[] height) {
        // create a stack - decreasing order -index
        Deque<Integer> dq = new ArrayDeque<>();
        int res = 0;
        // check height from left to right and heights[i] > heights[stack.peek()]
        for(int i = 0; i < height.length; i++) {
            while (!dq.isEmpty() && height[i] > height[dq.peek()]) {
                int cur = dq.pop();
                if (dq.isEmpty()) break;
                int left = dq.peek();
                int w = i - (left + 1);
                int h = Math.min(height[left], height[i]);
                res += (w * (h - height[cur]));
            }
            if (!dq.isEmpty() && height[i] == height[dq.peek()]) dq.pop();
            dq.push(i);
        }
        // collect the rain water
        // push the i into the stack
        return res;

    }
}
