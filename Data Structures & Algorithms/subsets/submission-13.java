class Solution {
    /*
    I'll use backtracking. 
    At each level, I immediately save the current path as a valid subset. 
    Then for each remaining element, I add it to the path, 
    recurse, and backtrack by removing it
    */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        return res;
    }
    private void backtrack(int start, int[] nums){
        res.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(i + 1, nums);// 从i + 1开始！！！！
            path.remove(path.size() - 1);
        }
    }
}
