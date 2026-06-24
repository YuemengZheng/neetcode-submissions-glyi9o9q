class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        /*
        I'll use backtracking. 
        At each step, I choose any element that hasn't been used yet and recurse. 
        When path size equals array size, I collect the result
        Time is O(n!) — at the first level we have n choices, then n-1, then n-2, and so on. 
        Space is O(n) for the recursion stack.
        */
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }
    private void backtrack(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            used[i] = true;
            path.add(nums[i]);
            backtrack(nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
