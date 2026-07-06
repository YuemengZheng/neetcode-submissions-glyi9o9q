/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    int path = 0;
    public int rob(TreeNode root) {
        /*
         For each node, there are two choices: rob or not rob. 
        The current decision affects the connected children — 
        if we rob the current node, the children cannot be robbed. 
        And the current result depends on the children's results. 
        So we use post-order DFS to first get the two states from each child, 
        then calculate the two states for the current node and pass them up. 
        The final answer is the max of the two states at the root. 
        The answer is the max of the two at the root.

        Main steps：
        Base case: if node is null, return [0, 0]. 
        Otherwise, get [leftRob, leftNotRob] from left child and [rightRob, rightNotRob] from right child. 
        
        Then:
        rob = node.val + leftNotRob + rightNotRob
        notRob = max(leftRob, leftNotRob) + max(rightRob, rightNotRob)

        Return [rob, notRob] and at the root take the max of the two."
        */
        int[] res = dfs(root);
        return res[0] > res[1] ? res[0] : res[1];
    }
    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int rob = left[1] + right[1] + root.val;
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, notRob};
    }
}