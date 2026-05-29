class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        // tree each level -> each num
        // for each num, choose it or skip it
        // there will be 2^h possibilities
        helper(0, nums);
        return res;
    }
    private void helper(int curIndex, int[] nums){
        if(curIndex == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        int num = nums[curIndex];
        path.add(num);
        helper(curIndex + 1, nums);
        path.remove(path.size() - 1);
        helper(curIndex + 1, nums);
    }
}
