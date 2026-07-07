class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // backtracking
        // each level choose one unvisited element
        // when we collect all the elements, copy that to the res

        // inputs are nums, boolean arr to avoid revisiting the same elements
        // when the path size reaches n, copy that to the res list
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited);
        return res;
    }
    private void backtracking(int[] nums, boolean[] visited){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                path.add(nums[i]);
                visited[i] = true;
                backtracking(nums, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
