class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // use backtrack
        // for each step, choose one element that is not been choosed
        // recurse
        // when the path size == arr size, collect the answer
        boolean[] used = new boolean[nums.length];
        backtrack(used, nums);
        return res;
    }
    private void backtrack(boolean[] used, int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(used, nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
