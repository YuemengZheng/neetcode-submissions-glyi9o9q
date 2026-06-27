class Solution {
    public int trap(int[] height) {
        // 用monotonic decreasing stack 不断找到能储水的区域，计算trapping water
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                // 对于 height[stack.peek()] < height[i], 其余都加入stack，我们的相等元素都会全部加入stack，直到遇到一个更高的height，才会一个一个被结算，但是后面的重复元素都是没有影响的，整个计算是压在第一个元素
                // 当height[stack.peek()] <= height[i]， 每次都会先加入，然后被下一个相等的元素替换，其实前面的过程计算结果都是0，直到遇到更高的，所以最后一个重复元素才是有效的，所有计算压在最后一个元素
                // stack.push(i) 可以限制条件，只有空或者比peek小的才能放进去，所以后面的重复元素是不会放进stack也不回被计算
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
