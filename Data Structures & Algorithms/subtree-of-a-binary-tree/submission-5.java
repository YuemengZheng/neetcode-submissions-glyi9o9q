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
        // So for every node in the big tree:
        // If its value matches subRoot's root, we compare both subtrees fully.
        // If they are identical, subRoot is a subtree.
        // Otherwise, continue searching on the left and right children.
        if(subRoot == null) return true;
        if(root == null) return false;

        // 从当前node对比
        if(dfs(root, subRoot)){
            return true;
        }
        // 不行的话尝试塔的左边或者右边，有一个可以就可以
        return isSubtree(root.left, subRoot)|| isSubtree(root.right, subRoot);
    }
    // check each node for the 
    private boolean dfs(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if(root.val != subRoot.val) return false;
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right); 
    }
}
