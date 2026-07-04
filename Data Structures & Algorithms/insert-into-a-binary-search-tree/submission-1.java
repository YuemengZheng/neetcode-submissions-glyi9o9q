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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // try to find a space to place the node and the tree is still binary
        // at each step, compare the val with the cur val, if it is smaller, go left, otherwise go right
        // until we find a empty place, because we wanna get the connected root, we wanna return root
        if(root == null) return new TreeNode(val);

        if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }else if(root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}