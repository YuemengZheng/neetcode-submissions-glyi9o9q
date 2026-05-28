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
        if(helper(root, subRoot)){
            return true;
        }
        if(root.left != null && isSubtree(root.left, subRoot)){
            return true;
        }
        if(root.right != null && isSubtree(root.right, subRoot)){
            return true;
        }

        return false;
    }

    private boolean helper(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;

        return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }
}
