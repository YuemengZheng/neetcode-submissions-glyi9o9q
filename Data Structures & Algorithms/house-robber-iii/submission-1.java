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
        The current node's decision affects its children — 
        if we rob it, children can't be robbed. And children's results accumulate up to affect the current decision. 
        So we use post-order DFS, where each node returns the max amount for both rob and not-rob cases

        High level：
        Use post-order DFS. For each node, return the max amount we can get if we rob or skip this node. 
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