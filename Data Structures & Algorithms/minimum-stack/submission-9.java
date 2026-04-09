class MinStack {
    // ***** TWO STACK => TIME: O(1), SPACE:O(n) *****
    // use stack to store all pushed values
    // use a minStack to store the minimum so far at each level
    // private Stack<Integer> stack;
    // private Stack<Integer> minStack;

    // public MinStack() {
    //     stack = new Stack<>();
    //     minStack = new Stack<>();
    // }
    
    // public void push(int val) {
    //     stack.push(val);
    //     if(minStack.isEmpty() || val <= minStack.peek()){ // 等于也要加上来，不然出现重复的数字会搞不清楚
    //         minStack.push(val);
    //     }
    // }
    
    // public void pop() {
    //     if(stack.isEmpty()) return;
    //     int top = stack.pop();
    //     if(top == minStack.peek()){// 设计到当前最小值的时候两个都要pop
    //         minStack.pop();
    //     }
    // }
    
    // public int top() {
    //     return stack.peek();
    // }
    
    // public int getMin() {
    //     return minStack.peek();
    // }

    // ***** ONE STACK => TIME: O(1), SPACE:O(1) *****
    // store the difference between val and min in the stack 
    // and use a variable min to keep track of the min
    // then we can recover both the actual value and the previous minimum in O(1) time.
    // 避免integer overflow
    private Stack<Long> stack;
    private long min;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L);
            min = val;
        }else{
            stack.push(val - min);
            if(val - min < 0){
                min = val;
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        long diff = stack.pop();
        if(diff < 0) min = min - diff;
    }
    
    public int top() {
        long diff = stack.peek();
        if(diff >= 0){
            return (int) (diff + min);
        }else{
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}

