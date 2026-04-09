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
        // dfs
        // for each root:
            // get the left path sum and the right path sum 如果<0 就舍弃
            // leftsum + rightsum + root.val
            // 更新res
            // return max(left, right) + cur.val
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;

        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));
        int cur = root.val + leftSum + rightSum;
        res = Math.max(res, cur);

        return Math.max(leftSum, rightSum) + root.val;
    }
}
