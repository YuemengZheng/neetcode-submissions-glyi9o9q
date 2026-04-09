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
        // 最长的path between two nodes
        // dfs/ input root/ out put is the longest length between two nodes
        // base case: root == null => return 0
        // longest length = left + right, 更新res
        // 返回上级要使path可以被延续，返回最长的一条边 =》 max(left, right) + 1
        // return res
        res = 0;
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(left + right, res);

        return Math.max(left, right) + 1;
    }
    
}
