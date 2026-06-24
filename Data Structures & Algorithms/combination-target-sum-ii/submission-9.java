class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /*
        I'll use backtracking. 
        First sort the array. 
        At each step, I try each remaining element, skip duplicates at the same level, 
        and recurse with index + 1. When sum equals target, collect the result.

        Time is O(2^n) since each element can be chosen or skipped. 
        Space is O(n) for the recursion stack.
        */
        Arrays.sort(candidates);
        backtrack(0, target, candidates);
        return res;
    }
    private void backtrack(int start, int target, int[] candidates){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], candidates);
            path.remove(path.size() - 1);
        }
    }
}
