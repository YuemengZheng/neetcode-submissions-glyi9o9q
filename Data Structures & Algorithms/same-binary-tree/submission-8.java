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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
        For each pair of nodes, check if they have the same structure and the same values, 
        then recursively check their left and right children.
        */

        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val){
            return false;
        }
        
        return isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right); 
    }
}
