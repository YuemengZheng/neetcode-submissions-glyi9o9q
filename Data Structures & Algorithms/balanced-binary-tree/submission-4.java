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
    public boolean isBalanced(TreeNode root) {
        // *********TC: O(n), SC: O(h)*********
        // TC: O(n) since each node is visited once
        // SC: O(h) due to the recursion stack (tree height)
        // for each node, we need two info:
        // 1. if the subtree unbalanced => -1 
        // 2. the height of the subtree 
        // This way, each subtree is processed only once
        return dfs(root) == -1 ? false : true;
    }
    // 
    private int dfs(TreeNode root){
        // base case
        if(root == null) return 0;

        // for each node:
        // get left and right subtree heights
        // if either is unbalanced or the height difference > 1 => return -1
        // otherwise return current height
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
