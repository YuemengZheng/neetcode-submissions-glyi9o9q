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
    public TreeNode deleteNode(TreeNode root, int key) {
        // recursion to find the target node, then delete it
        // the tricy is there will be several situations to consider
        // 1. if the node is leaf node return null
        // 2. only has one child, return that child
        // 3. has two children: need to choose a candidate
        //  - left child's right is null, let the left child to be the root
        //  - left child's right is not null, get the right most child as the root
        if(root == null) return null;

        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            if(root.left.right == null){
                root.left.right = root.right;
                return root.left;
            }else{
                TreeNode pre = root.left;
                TreeNode cur = pre.right;
                while(cur.right != null){
                    pre = cur;
                    cur = cur.right;
                }
                pre.right = cur.left;
                cur.left = root.left;
                cur.right = root.right;
                return cur;
            }
        }
        return root;
    }
}