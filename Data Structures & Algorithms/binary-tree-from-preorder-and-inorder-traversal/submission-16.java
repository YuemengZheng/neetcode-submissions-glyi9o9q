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
        // preoder get the first element
        // inorder get the size of left subtree and size of right subtree
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }
    private TreeNode dfs(int[] preorder, int preLeft, int preRight, 
    int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        if(preLeft > preRight) return null;

        TreeNode root = new TreeNode(preorder[preLeft]);
        int midIndex = map.get(preorder[preLeft]);
        int leftSize = midIndex - inLeft;
        root.left = dfs(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, midIndex - 1, map);
        root.right = dfs(preorder, preLeft + leftSize + 1, preRight, inorder, midIndex + 1, inRight, map);
        return root;
    }
}
