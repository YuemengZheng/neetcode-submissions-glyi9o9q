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
        // for each node, the differ in height of left and right children is no more than 1
        // int -> -1 represents this subtree is not a balanced, numbers greater than -1, represents the height
        int res = helper(root);
        return res == -1 ? false : true;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        if(left == -1) return -1;

        int right = helper(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
