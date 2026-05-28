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
    int res  = 0;
    public int goodNodes(TreeNode root) {
        /*
        Use DFS, tracking the max value along the path from root. 
        If a node's value is greater than or equal to the path max, it's a good node.
        */
        dfs(root, Integer.MIN_VALUE);
        return res;
    }
    private void dfs(TreeNode root, int pathMax){
        if(root == null) return;

        if(root.val >= pathMax){
            res++;
            pathMax = root.val;
        }
        dfs(root.left, pathMax);
        dfs(root.right, pathMax);
    }
}
