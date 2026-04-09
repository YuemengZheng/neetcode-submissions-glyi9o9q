class Solution {
    public int largestRectangleArea(int[] heights) {
        // 对于每个 bar，左边第一个比它小的位置在哪里，右边第一个比它小的位置在哪里
        // 找最近更小元素用Monotonic Increasing Stack
        // ***** TIME: O(n), SPACE:O(n) *****
        /*
        The brute force approach is to treat each bar as the height of the rectangle, then expand to the left and right as long as the bars are at least as tall as the current bar.
        Once we hit a smaller bar, we stop.
        This gives the maximum width for that bar as the limiting height.
        Since we may scan left and right for every bar, the total complexity is O(n²).
        To optimize, we don’t want to repeatedly scan left and right for every bar.
        What we really need for each bar is the first smaller bar on the left and the first smaller bar on the right.
        Once we know these two boundaries, we can directly compute the width and area.
        This can be done in O(n) using a monotonic increasing stack.    
        */
        int n = heights.length;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 对于n的高度是0，因为我们需要一个更小的右边界，使得stack里面的剩余的index都弹出来计算面积
        // 对于 -1，如果stack是空的，我们没有smaller ball on the left, so we treat the boundary as -1
        for(int i = 0; i <= n; i++){
            int curHeight = (i == n) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > curHeight){
                int h = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                res = Math.max(res, width * h);
            }
            stack.push(i);
        }
        return res;
    }
}
