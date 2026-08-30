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
    public TreeNode invertTree(TreeNode root) {
        // pre order traversal
        // base case, when the root is null || it is leaf node return 
       // for each root, recursively change the position of its children
       // recursively do the same process
       if(root == null || root.left == null && root.right == null) return root;

       TreeNode temp = root.left;
       root.left = root.right;
       root.right = temp;

       invertTree(root.left);
       invertTree(root.right);

       return root;
    }
}
