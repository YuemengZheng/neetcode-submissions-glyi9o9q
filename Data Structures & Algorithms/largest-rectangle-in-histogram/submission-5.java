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
        // 对于每一个i而言，我们假设矩形的高度就是heights[i],所以我们要寻找左边和右边height小与它的最近的位置
        // 面积就是 （right - left - 1） * heights[i]
        // brute force 是n^2，我们可以通过increasing stack去做优化，不再重复工作
        // increasing stack的作用是 stack里面存的都increasing height对应的index，相当于左边已经可以判定left，
        // 右边只要要加入的height比peek小，那么右边的边界也确定下来了，这个peek的index就可以先计算了，这样能做到n
        int n = heights.length;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 对于左右的边界处理方便，我们要设定 -1 和 n的height为0
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
