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
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // dfs + hashmap
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR){
        if(preL > preR) return null;
        int midNum = preorder[preL];
        TreeNode root = new TreeNode(midNum);
        int midIndex = inorderMap.get(midNum);
        int leftSize = midIndex - inL;
        int rightSize = inR - midIndex;
        root.left = dfs(preorder, preL + 1, preL + leftSize, inorder, inL, midIndex - 1);
        root.right = dfs(preorder, preL + leftSize + 1, preR, inorder, midIndex + 1, inR);
        return root;
    }
}
