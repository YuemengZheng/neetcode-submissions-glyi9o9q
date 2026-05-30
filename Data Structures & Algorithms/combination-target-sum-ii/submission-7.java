class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // use backtrack
        // first sort the arr
        // for each level, choose a num in the remaining elements,skip all the duplicates
        // recurse with index + 1
        // when sum equals target, collect the res
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
