class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        // backtracking
        // each level, choosing one unvisited element, and skip all the duplicates, to avoid the same permutation
        // when the path has n elements, add the path to the res

        // 1. sort the arr to let all the duplicates stay together
        // 2. use a helper function to collect all the permutaions
        //  - input: nums, boolean visited arr
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited);
        return res;
    }
    private void backtracking(int[] nums, boolean[] visited){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] || i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;

            path.add(nums[i]);
            visited[i] = true;
            backtracking(nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
