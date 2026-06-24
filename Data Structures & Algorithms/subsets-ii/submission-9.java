class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        I'll use backtracking. 
        First sort the array. for each remaining element, skip duplicates at the same level, 
        and recurse with index + 1. At each node, immediately save the current path. 

        Time is O(2^n) since each element can be chosen or skipped. Space is O(n) for the recursion stack.
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
