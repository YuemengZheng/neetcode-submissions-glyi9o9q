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
    int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // recursion
        // base case: if root is null return 0
        // recursive rule: get the max path from left and right children, 
        // sum up them together as the max path passing through current root, update the global res
        // pass the greater one + 1 as the current longest side path to parent
        helper(root);
        return maxPath;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        maxPath = Math.max(maxPath, left + right);
        return Math.max(left, right) + 1;
    }
}
