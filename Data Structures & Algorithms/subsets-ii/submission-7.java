class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        use backtrack, sort the arr frist,
        for each step, choose one element in the remaining arr, skip all the duplicates at the same level
        recurse with index + 1
        collct all the subset 
        */
        Arrays.sort(nums);
        backtrack(0, nums);
        return res;
    }
    private void backtrack(int start, int[] nums){
        res.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
