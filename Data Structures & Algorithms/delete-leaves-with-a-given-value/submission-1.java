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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        /*
        I use post-order traversal because we need to process children first. 
        Base case: if the root is null, return null. 
        Otherwise, recursively remove leaf nodes from the left and right subtrees. 
        Then check: if both left and right are null and the current value equals target,
        we delete this node by returning null. 
        Otherwise, we reconnect the left and right subtrees and return the current node.
        */
        
        if(root == null) return null;
        
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        if(left == null && right == null && root.val == target){
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}