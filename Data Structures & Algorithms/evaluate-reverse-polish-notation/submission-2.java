class Solution {
    public int evalRPN(String[] tokens) {
        // ***** TIME: O(n), SPACE:O(n) *****
        // 因为计算的规律是数字在前，运算符号在后，所以我们，每次遇到符号的时候，需要得到前面的两个数字去计算
        // 这个就可以用stack解决，当我们遇到是数字的时候先入栈，遇到符号的时候把数字弹出两个，然后计算出结果再入栈
        Stack<Integer> stack = new Stack<>();
        for(String c : tokens){
            if(c.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(c.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            }else if(c.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(c.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }else{
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
