class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        /*
        For the high level, I use backtracking to collect all permutations. 
        The tricky part is handling duplicates. So first I sort the array to group duplicates together, 
        then I use a visited boolean array to avoid revisiting elements and to skip duplicates.

        Let's say the input is [1,1,2]. For the first position, all three elements are not visited, 
        so each is valid. But the first element and the second element have the same value — 
        if we choose either one, the permutation will be the same.
        So we want to skip the second one and only use the first one. 
        Later when the first one is backtracked, then we can use the second one.

        For the main steps, I use a helper function with inputs: the array and the visited array.
        The base case is when path size equals n, we add the current path to the result.
        Otherwise, we iterate through all elements. We skip if the element is already visited. 
        We also skip if the current element equals the previous one and the previous one is not visited — 
        this ensures we only use duplicates in order, avoiding duplicate permutations.
        Otherwise, we add the element to the path, mark it as visited, recurse, 
        then backtrack by removing it and marking it as unvisited.

        O(n! * n) | O(n)
        */
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited);
        return res;
    }
    private void backtracking(int[] nums, boolean[] visited){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            // 没有 return 的话会多跑一次 for loop，但因为所有元素都被 visited 了，所以 for loop 什么都不做，不影响结果但是浪费时间。
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // 这里思考的时候思路很乱，需要再思考清楚我们到底要跳过的是什么
            if(visited[i] || i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;

            path.add(nums[i]);
            visited[i] = true;
            backtracking(nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
