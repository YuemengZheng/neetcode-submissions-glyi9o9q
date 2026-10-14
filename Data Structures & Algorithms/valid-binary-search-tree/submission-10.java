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
        // for each node, it will have the range
        // for each node it will greater than all its left chidren and samller than all it's right children
        return recursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean recursive(TreeNode root, int leftBound, int rightBound) {
        if(root == null) return true;
        if(root.val <= leftBound || root.val >= rightBound) return false;

        return recursive(root.left, leftBound, root.val) && recursive(root.right, root.val, rightBound);
    }
}
