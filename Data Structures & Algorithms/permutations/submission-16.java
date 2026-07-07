class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
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
