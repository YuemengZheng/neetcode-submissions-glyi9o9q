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
        // get the res from left and right children, if either is -1, return -1
        // if the differ in those two values are greater than 1 return -1
        // return the greater one + 1 to parent
        return helper(root) == -1 ? false : true;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
