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
        // At each node, I consider two things:
        // 1. For updating the global maximum:
        //    I can include both left and right branches, because the path can end at this node.

        // 2. For returning to the parent:
        //    I can only choose one side, because the path must be extendable and cannot split into two directions.
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;

        // for the root update a global maximum by considering both left and right paths as a complete path.
        // and we only consider the 有正面和积极影响的path sum
        int leftSum = Math.max(0, dfs(root.left));// negative paths never help maximize the sum, so we ignore them
        int rightSum = Math.max(0, dfs(root.right));
        int cur = root.val + leftSum + rightSum;
        res = Math.max(res, cur);

        // when pass the sum to the parent, only choose one side, cause
        return Math.max(leftSum, rightSum) + root.val;
    }
}
