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
    public boolean isBalanced(TreeNode root) {
        // *********TC: O(n), SC: O(h)*********
        // TC: O(n) since each node is visited once
        // SC: O(h) due to the recursion stack (tree height)
        
        /*
        We use recursion, and for each node we need two pieces of information: 
        whether the subtree is balanced and its height.
        We get this information from the left and right children.
        If either subtree is unbalanced, we return unbalanced immediately.
        Otherwise, we check the difference in height between the two subtrees.
        If the difference is greater than one, the current subtree is unbalanced.
        Otherwise, we return the current subtree as balanced, and pass the height 
        as the maximum of the two heights plus one to the parent.
        */
        return dfs(root) == -1 ? false : true;
    }
    // 
    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left == -1 || right == -1){
            return -1;
        }

        if(Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
