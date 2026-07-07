class Solution {
    public boolean makesquare(int[] matchsticks) {
        // try to divide the arr into four sections, each section has the same sum
        // helper function takes: arr, visited boolean arr, lensum, targetlensum, cnt return true or false
        // base case: if the cnt == 3 return true
        // otherwise if lensum == targetsum, we need reset the lensum = 0 and increment the cnt, call dfs to find other len
        // otherwise update the lensum and mark as visited, recurse, backtrack by adding back the totalSum, mark as unvisited
        // if we cannot find the correct path, return false

        // 可以用totalsum，但是可能有一种情况len = 33, sum = 33, nums[i] = 66, res = 99, cnt++，但实际上 66 > 33，不可能是一条边！
        // 用totalsum逻辑很绕，有bug 找不出来
        // 还是用lenSum, len, cnt, 一条一条边check，比较清晰

        /*
        for loop 里的递归：负责尝试每个未被访问的元素，recurse，如果找到合适的path就 return true，全试完找不到就 return false
        lenSum == targetLenSum 的递归：只是一个"中转站"，重置 lenSum，cnt++，然后把结果传回去
        两者串联：for loop 不断累积 lenSum，累积到 targetLenSum 就触发中转，中转完继续让 for loop 找下一条边。
        */

        int sum = 0;
        for(int num : matchsticks){
            sum += num;
        }
        if(sum % 4 != 0) return false;

        Arrays.sort(matchsticks);
        for(int i = 0, j = matchsticks.length - 1; i < j; i++, j--){
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        
        boolean[] visited = new boolean[matchsticks.length];
        return backtracking(matchsticks, visited, 0, sum / 4, 0);
    }
    private boolean backtracking(int[] matchsticks, boolean[] visited, int lenSum, int targetLenSum, int cnt){
        if(cnt == 3) return true;

        if(lenSum == targetLenSum) {
            return backtracking(matchsticks, visited, 0, targetLenSum, cnt + 1);
        }

        for(int i = 0; i < matchsticks.length; i++){
            /*
            continue：只是跳过当前这个 candidate，继续尝试下一个
            return false：当前及之后所有路径都不可行，直接放弃
            最后的 return false：所有 candidate 都试过了，没有找到合法路径
            */
            if(visited[i] == true) continue; 
            if(i > 0 && matchsticks[i] == matchsticks[i-1] && !visited[i-1]) continue; 
            if(lenSum + matchsticks[i] > targetLenSum) continue; 
            
            lenSum += matchsticks[i];
            visited[i] = true;
            if(backtracking(matchsticks, visited, lenSum, targetLenSum, cnt)) return true;
            lenSum -= matchsticks[i];
            visited[i] = false;
        }
        return false;
    }
}