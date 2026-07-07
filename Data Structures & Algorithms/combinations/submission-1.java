class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // choose k elements from the range[1, n]
        // helper function: takes n, k, startNum
        backtracking(n, k, 1);
        return res;       
    }
    private void backtracking(int n, int k, int startNum){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        if(startNum > n){
            return;
        }

        for(int i = startNum; i <= n; i++){
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}