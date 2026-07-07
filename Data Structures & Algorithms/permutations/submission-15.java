class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        /*
        Our goal is to get all permutations of the given array. 
        My idea is to use backtracking.

        for the recursion tree, Each level represents choosing one unvisited element. 
        Since we need all n elements, the tree is n levels deep.

        For the main steps, I use a helper function with inputs: the array and a visited boolean array 
        to avoid revisiting the same element.
        The base case is when path size equals n, we copy the current path to the result.
        Otherwise, we iterate through all elements. 
        If the element is not visited, we add it to the path, mark it as visited, 
        recurse, then backtrack by removing it and marking it as unvisited.

        Time complexity is O(n! * n) because there are n! permutations and copying each path takes O(n). 
        Space complexity is O(n) for the recursion stack, visited array, and path
        */
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited);
        return res;
    }
    private void backtracking(int[] nums, boolean[] visited){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                path.add(nums[i]);
                visited[i] = true;
                backtracking(nums, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
