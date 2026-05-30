class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // for each step: choose a num from the remaining arr
        // recurse
        // if sum == target -> collect the result
        backtrack(0, 0, nums, target);
        return res;
    }
    private void backtrack(int start, int sum, int[] nums, int target){
        if(sum >= target){
            if(sum == target){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(i, sum + nums[i], nums, target);// can repeat
            path.remove(path.size() - 1);
        }
    }
}
