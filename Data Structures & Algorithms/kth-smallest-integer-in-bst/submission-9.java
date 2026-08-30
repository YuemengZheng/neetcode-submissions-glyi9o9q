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
    int cnt; // ***** ERROR1 ******
    int res;
    public int kthSmallest(TreeNode root, int k) {
        /*
        Use inorder traversal to visit nodes in ascending order, 
        counting down from k.
        When the count reaches zero, the current node is the kth smallest.
        */
        cnt = k;
        helper(root);
        return res;
    }
    private void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);
        if(--cnt == 0){
            res = root.val;
            return;
        }
        helper(root.right);
    }
}
