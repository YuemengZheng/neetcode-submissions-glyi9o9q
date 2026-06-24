class Solution {
    /*
    'll use backtracking. 
    At each level, I iterate through all the possible elements starting from a given index. 
    For each one, I add it to the path and recurse on the next index.
    And since every path along the way is a valid subset, I collect the answer at each node

    Now let me walk through the main steps of the backtrack function.
    The function takes two inputs: the start index and the array.
    For the base case — since every node is a valid subset, I collect it right away.
    Then at each level, I loop through the elements starting from the start index. 
    For each element, I add it to the path, recurse on the next index, and then remove it to backtrack. 

    I'll use two global variables: res to store all subsets, and path to track the current subset
    Then I call backtrack starting from index 0
    
    */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        return res;
    }
    private void backtrack(int start, int[] nums){
        res.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
/*
Let me walk through with nums = [0, 1, 2].
I start by calling backtrack with an empty path. The first thing I do is collect the empty path.
Then I loop starting from index 0. I add 0, and I collect it. I recurse forward — I add 1, path is [0, 1], collect it. 
I recurse again, add 2, path is [0, 1, 2], collect it. Now there's nothing left, so I backtrack: I remove 2, then remove 1, back to [0].
Next, I try 2 instead, giving [0, 2], and collect it. Then I backtrack all the way to the empty path.
Now I move to index 1: I add 1, path is [1], collect it, then go forward to [1, 2]. Backtrack.
Finally index 2: I add 2, path is [2], collect it.
So the res will be like this [], [0], [0,1], [0,1,2], [0,2], [1], [1,2], and [2]."

For time complexity, there are 2ⁿ subsets in total, since each element can either be included or not. 
For each subset, I make a copy of the path, which takes O(n). So the total time is O(n × 2ⁿ).
For space, not counting the output, it's O(n) — that's the recursion stack 
*/
