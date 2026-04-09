class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // ***** STACK => TIME: O(n), SPACE:O(n) *****
        // 找到 > i 的最小的index，其temp[index] > temp[i]
        // brute force => n^2,重复访问，需要优化
        // use a monotonic decreasing stack
        // 当数字是decreasing的时候先存在stack，等到后面有大的数字再弹出来，填到结果
        // 因为我们需要填写的是天数，所以我们stack中存储的是index

        // int[] res = new int[temperatures.length];
        // Stack<Integer> stack = new Stack<>();
        
        // for(int i = 0; i < temperatures.length; i++){
        //     int t = temperatures[i];
        //     while(!stack.isEmpty() && temperatures[stack.peek()] < t){
        //         res[stack.peek()] = i - stack.peek();
        //         stack.pop();
        //     }
        //     stack.push(i);
        // }
        // return res;

        // ***** DP =>TIME: O(n), SPACE:O(1) *****
        // process from right to left
        // res[i] means how many days we need to wait for a warmer temperature
        // if the next day j is not warmer than i,
        // we can jump to j + res[j] instead of moving one step at a time
        // because res[j] already tells us where the next warmer day for j is
        int n = temperatures.length;
        int[] res = new int[n];

        for(int i = n - 2; i >= 0; i--){
            int j = i + 1;
            while(true){
                if(temperatures[j] > temperatures[i]){
                    res[i] = j - i;
                    break;
                }
                if(res[j] == 0){
                    break;
                }
                j += res[j];
            }
        }
        return res;
    }
}
