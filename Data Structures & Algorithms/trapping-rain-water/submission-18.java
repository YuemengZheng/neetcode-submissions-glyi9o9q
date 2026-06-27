class Solution {
    public int trap(int[] height) {
        // monotonic decreasing stack to store indices

        // 1. initializa a decreasing stack and iterate through the arr
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < height.length; i++){
        //   when we find a bar taller than the stack top
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
        //     pop the top to get basin bottom
                int bottom = height[stack.pop()];
        //     if the stack is not empty, new top is the left wall, get the water height
                if(!stack.isEmpty()){
                    int waterHeight = Math.max(0, Math.min(height[stack.peek()], height[i]) - bottom);
                    int width = i - stack.peek() - 1;
                    res += waterHeight * width;
                }
            }
        // 2. push the cur index on the stack
            stack.push(i);
        }
        return res;
    }
}

/*
1 0 2

i = 0, h = 1
i = 1, h = 0
i = 2, h = 2
stack[0,  ]
bottom = 1
height = 1
width = 1
res = 1
*/
