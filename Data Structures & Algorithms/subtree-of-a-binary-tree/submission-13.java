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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // *********TC: O(n * m), SC: O(h1 + h2)*********
        /*
        For each node in the main tree, 
        check if the subtree rooted at that node is the same as subRoot. 
        If it matches, return true. 
        Otherwise, recursively check the left and right children.
        */
        if(subRoot == null) return true;
        if(root == null) return false;
        if(dfs(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    // check each node for the 
    private boolean dfs(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if(root.val != subRoot.val) return false;
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right); 
    }
}
