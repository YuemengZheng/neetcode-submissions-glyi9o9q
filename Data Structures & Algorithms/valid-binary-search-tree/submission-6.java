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
        // binary search tree 
        // try to check if all the node's value is within the range
        // cur.val > left subtree && < right subtree
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean helper(TreeNode root, int leftBoundary, int rightBoundary){
        if(root == null) return true;

        if(root.val <= leftBoundary || root.val >= rightBoundary){
            return false;
        }
        return helper(root.left, leftBoundary, root.val) &&
            helper(root.right, root.val, rightBoundary);
    }
}
