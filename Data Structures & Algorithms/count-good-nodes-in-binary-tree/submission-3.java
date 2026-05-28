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
    int cnt = 0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return cnt;
    }
    private void helper(TreeNode root, int curMax){
        if(root == null) return;

        if(root.val >= curMax){
            cnt++;
            curMax = Math.max(root.val, curMax);
        }
        helper(root.left, curMax);
        helper(root.right, curMax);
    }
}
