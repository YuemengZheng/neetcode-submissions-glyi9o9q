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
        // always get the root form the preorder
        // build the root
        // use root to find the position in the inorder
        // parse the arr into two halves
        // recersively do the same process for it's children
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            numToIndex.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1, numToIndex);
    }
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> numToIndex) {
        if(preStart > preEnd) return null;

        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int middle = numToIndex.get(val);
        int leftSize = middle - inStart;
        root.left = helper(preorder, preStart + 1, preStart + leftSize, inorder, inStart, middle - 1, numToIndex);
        root.right = helper(preorder, preStart + leftSize + 1, preEnd, inorder, middle + 1, inEnd, numToIndex);
        return root;
    }
}
