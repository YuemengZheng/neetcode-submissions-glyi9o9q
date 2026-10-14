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
        // use inorder traversal so we can visit the tree in order
        cnt = k;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root) {
        if(root == null) return;

        dfs(root.left);
        if(--cnt == 0) {
            res = root.val;
            return;
        } 
        dfs(root.right);
    }
}
