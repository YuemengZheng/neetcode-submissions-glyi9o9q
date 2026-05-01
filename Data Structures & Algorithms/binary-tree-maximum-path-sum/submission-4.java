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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // 对于max path sum passing through cur node
        // - get the path sum from left and right subtrees, sum up with cur val, update the globalmax
        // 对于 path sum ending at cur node
        // - get greater of path sum from left and right subtree, plus cur val to pass to the parent
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        
        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));

        res = Math.max(res, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
