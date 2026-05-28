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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // use preorder to always get the root node
        // then find the root position in the inorder,
        // get the left partition and right partition
        // recursively do the same process to build the tree

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorderMap, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inorderMap, int inStart, int inEnd){
        if(preStart > preEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inorderMap.get(rootVal);
        int leftSize = rootIndex - inStart;
        root.left = helper(preorder, preStart + 1, leftSize + preStart, inorderMap, inStart, inStart + leftSize - 1);
        root.right = helper(preorder, leftSize + preStart + 1, preEnd, inorderMap, rootIndex + 1, inEnd);
        return root;
    }
}
