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
    public List<Integer> inorderTraversal(TreeNode root) {
        /*
        "Use DFS to traverse the tree. 
        The base case is when the node is null, we return. 
        Otherwise, we recursively go left first, then collect the current node's value, 
        then recursively go right. This guarantees left → root → right order."
        */
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res){
        if(root == null) return;

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}