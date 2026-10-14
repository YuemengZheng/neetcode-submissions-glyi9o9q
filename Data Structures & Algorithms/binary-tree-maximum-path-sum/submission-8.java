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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        /*
        To find the maximum path sum, for each node, 
        I compute the best path passing through the current node and update the global maximum. 
        Then I return the larger one-sided path to the parent so it can continue extending the path.
        */
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        
        /*
        we take the max with 0, because if a subtree's path sum is negative, we'd better skip it.
        */
        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));

        res = Math.max(res, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
