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
        /*
        use recursion, for each step, compare the val with the cur node, and choose to go left or right
        until we find the right position

        For the main steps, 
        first, the base case: if the root is null, it means we found the right position. 
        We create a new node and return it. Otherwise, if the value is smaller than the current node, we go left. 
        Otherwise, we go right. Finally, we reconstruct the tree and return the current node.
        */
        if(root == null) return new TreeNode(val);

        if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }else if(root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}