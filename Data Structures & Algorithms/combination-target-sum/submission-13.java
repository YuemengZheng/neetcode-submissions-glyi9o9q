class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // sort the arr
        // use dfs, each level can choose one element from the rest of the arr
        // when the sum reaches target, collect the list
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(nums, target, 0);
        return res;
    }
    private void backtrack(int[] nums, int target, int startIndex) {
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;

        for(int i = startIndex; i < nums.length; i++) {
            int cur = nums[i];
            path.add(cur);
            target -= cur;

            backtrack(nums, target, i);

            path.remove(path.size() - 1);
            target += cur;
        }
    }
}
