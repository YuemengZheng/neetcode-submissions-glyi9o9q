class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, candidates, target);
        return res;
    }
    private void backtrack(int start, int[] candidates, int target){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            backtrack(i + 1, candidates, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
