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
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        // get the longest path between any two nodes
        // for each node, get the longest path from its left and right children
        // for the path passing through cur root => longgest length = left + right 
        // update the max path
        // use greater one of left and right + 1 represents the cur length, pass the length to the parent
        res = 0;
        helper(root);
        return res;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

}
