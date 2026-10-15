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
    int res;
    public int kthSmallest(TreeNode root, int k) {
        // inorder traversal get the kth smallest element
        cnt = k;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root) {
        if(root == null) return;

        dfs(root.left);
        if(--cnt == 0) res = root.val;
        dfs(root.right);
    }
}
