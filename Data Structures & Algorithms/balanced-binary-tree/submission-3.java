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
        // for each node => the height of its left subtree and its right subtree are differ no more than one
        // the input is root, we need height, if they are balance 
        // so we use -1 => unbalanced, use num greater than or equals 0 => height
        return dfs(root) == -1 ? false : true;
    }
    private int dfs(TreeNode root){
        // base case
        if(root == null) return 0;

        // each node
        // process the left and right subtree
        int left = dfs(root.left);
        int right = dfs(root.right);
        // if either one is not balanced return -1
        if(left == -1 || right == -1) return -1;
        // else check if they are differ by no more than one
        // if no, return -1, else return the height of the tree
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
