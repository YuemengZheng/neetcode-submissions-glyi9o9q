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
        /*
        To solve this problem, I use recursion to find the target node and delete it.
        The tricky part is handling three cases when the node is found:
        First, if the node has no children or only one child, I just return that child or null.
        Second, if the node has two children, I need to find a replacement candidate. I choose the rightmost node in the left subtree.
        If the left child has no right child, I simply use the left child as replacement and reconstruct the tree.
        If the left child has a right child, I find the rightmost node in the left subtree, reconstruct the tree
        */
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