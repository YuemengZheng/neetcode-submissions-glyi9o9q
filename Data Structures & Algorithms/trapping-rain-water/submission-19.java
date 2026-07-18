class Solution {
    public int trap(int[] height) {
        /*
        I'll use a monotonic decreasing stack to store indices. 
        When I find a bar taller than the stack top, it means I've found a basin where water can be trapped. 
        I can then compute the water between the two higher bars

        The main steps: I iterate through the array maintaining a decreasing stack of indices. 
        When I find a bar higher than the stack top, I pop the top as the basin bottom. 
        If the stack still isn't empty, the new top is the left wall and the current bar is the right wall. 
        The water height is the shorter wall minus the basin bottom, and the width is the distance between the two walls. 
        I add that to the result and push the current index onto the stack.
        */
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                // 1. 对于 height[stack.peek()] < height[i], 其余都加入stack，我们的相等元素都会全部加入stack，直到遇到一个更高的height，才会一个一个被结算，但是后面的重复元素都是没有影响的，整个计算是压在第一个元素
                // 2.当height[stack.peek()] <= height[i]， 每次都会先加入，然后被下一个相等的元素替换，其实前面的过程计算结果都是0，直到遇到更高的，所以最后一个重复元素才是有效的，所有计算压在最后一个元素
                // 3. stack.push(i) 可以限制条件，相等的时候需要替换，可以不被重复计算，替换是必须的！！因为这个重复的元素不仅仅是作为midheight，它还作为leftborder，不替换index，会导致res偏大
                int midHeight = height[stack.pop()];
                if(!stack.isEmpty()){
                    res += Math.max(0, Math.min(height[stack.peek()], height[i]) - midHeight) * (i - stack.peek() - 1);
                }
            } 
            if(!stack.isEmpty() && height[stack.peek()] == height[i]){
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}

