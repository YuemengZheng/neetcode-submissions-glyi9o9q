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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // // *********TC: O(h), SC: O(h)*********
        /*
        In a normal binary tree we must search both subtrees because there is no ordering property.
        But in a BST, we can use the ordering property. 
        If both nodes are smaller than the root we go left, 
        if both are larger we go right. 
        Otherwise the current node is the LCA.
        */

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        // 在他们中间或者等于他们其中一个
        return root;
    }
}
