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
        // inorder traversal
        cnt = k;
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root) {
        if(root == null) return;

        traverse(root.left);
        if(--cnt == 0){
            res = root.val;
        }
        traverse(root.right);
    }
}
