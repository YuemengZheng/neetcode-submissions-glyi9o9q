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
        // Start DFS from the root and store the root's value as the current maxSoFar
        // At each node
            // If node.val >= maxSoFar, count it as a good node.
            // Update maxSoFar = max(maxSoFar, node.val).
        // Recursively explore
        // return sum
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
