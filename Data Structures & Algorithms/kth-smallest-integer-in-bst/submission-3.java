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
    int cnt;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        /*
        Use the property of a BST, where inorder traversal gives elements in sorted order.
        We use a counter to track how many nodes we've visited.
        When the counter reaches k, the current node is the result.
        */
        cnt = k;
        helper(root);
        return res;
    }
    private void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);
        if(--cnt == 0){
            res = root.val;
        }
        helper(root.right);
    }
}
