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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean helper(TreeNode root, int leftBound, int rightBound){
        if(root == null) return true;
        if(root.val >= rightBound || root.val <= leftBound){
            return false;
        }

        return helper(root.left, leftBound, root.val) &&
               helper(root.right, root.val, rightBound);
    }
}
