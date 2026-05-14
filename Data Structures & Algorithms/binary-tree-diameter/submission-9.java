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
       /*
        use recursion
        for each node, get the longest path length from its left and right children
        the longest path passing through the cur node is the sum of two values
        so we will update the global max with it
        then pass the larger of the two path lengths + 1 to the parent
       */
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
