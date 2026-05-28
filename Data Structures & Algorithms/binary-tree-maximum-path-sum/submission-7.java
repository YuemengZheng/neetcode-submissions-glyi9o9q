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
        Use DFS. 
        For each node, get the max path sum from its left and right children. 
        Update the global max with the sum passing through the current node. 
        Return the greater side plus current value to the parent.
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
