class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // ***** TIME: O(n), SPACE:O(n) *****
        // 找到 > i 的最小的index，其temp[index] > temp[i]
        // brute force => n^2,重复访问，需要优化
        // use a monotonic decreasing stack
        // 当数字是decreasing的时候先存在stack，等到后面有大的数字再弹出来，填到结果
        // 因为我们需要填写的是天数，所以我们stack中存储的是index

        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < temperatures.length; i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < t){
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
