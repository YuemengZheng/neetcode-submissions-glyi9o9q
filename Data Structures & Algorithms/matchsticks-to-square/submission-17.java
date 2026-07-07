class Solution {
    public boolean makesquare(int[] matchsticks) {
        /*
        High level:
        "Use backtracking to try to divide the array into four groups with equal sum. 
        First check if the total sum is divisible by 4, then sort the array in descending order for better pruning."

        Main steps:
        "I use a helper function with inputs: the array, a visited boolean array, 
        the current edge sum, the target edge length, and the count of completed edges.
        The base case is when cnt equals 3, we return true since the fourth edge is guaranteed.
        If the current edge sum equals the target, we reset it to 0 and increment cnt to start the next edge.
        Otherwise, we iterate through all unvisited elements. We skip if the element is already visited, 
        if adding it exceeds the target, or if it equals the previous unvisited element to avoid duplicates.
        We add the element, mark it as visited, recurse, then backtrack by removing it and marking it as unvisited.

        Time complexity is O(4 * n!) in the worst case, but with pruning — sorting, 
        skipping elements that exceed the target, and skipping duplicates — 
        the actual performance is much better. 
        Space complexity is O(n) for the recursion stack and visited array.
        */
     

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
        // 因为这个多加了3层stack
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