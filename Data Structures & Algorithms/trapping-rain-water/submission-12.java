class Solution {
    public int trap(int[] height) {
        // 用monotonic decreasing stack 不断找到能储水的区域，计算trapping water
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++){

            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int midHeight = height[stack.pop()];
                if(!stack.isEmpty()){
                    res += Math.max(0, Math.min(height[stack.peek()], height[i]) - midHeight) * (i - stack.peek() - 1);
                }
            } 
            stack.push(i);
        }
        return res;
    }
}
