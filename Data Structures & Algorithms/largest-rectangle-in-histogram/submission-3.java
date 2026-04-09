class Solution {
    public int largestRectangleArea(int[] heights) {
        // 对于每个 bar，左边第一个比它小的位置在哪里，右边第一个比它小的位置在哪里
        // 找最近更小元素用Monotonic Increasing Stack
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
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for(int i = 0; i <= n; i++){
            int curHeight = (i == n) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek() ]> curHeight){
                int h = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                res = Math.max(res, h * width);
            }
            stack.push(i);
        }
        return res;
    }
}
