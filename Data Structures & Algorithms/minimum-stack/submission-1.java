class MinStack {
    // ***** TIME: O(1), SPACE:O(n) *****
    // use stack to store all pushed values
    // use a minStack to store the minimum so far at each level
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){ // 等于也要加上来，不然出现重复的数字会搞不清楚
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int top = stack.pop();
        if(top == minStack.peek()){// 设计到当前最小值的时候两个都要pop
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

