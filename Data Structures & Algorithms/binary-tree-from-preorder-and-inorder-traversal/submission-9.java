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
    // use hashmap to help us find the middle elements in the inorder array in o(1) time
    Map<Integer, Integer> middleIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        We use preorder and inorder together to rebuild the tree.
        Preorder tells us the root of the current subtree, 
        and inorder tells us how to split that subtree into left and right parts.
        We use a hashmap to quickly find the root position in inorder, 
        calculate the left and right subtree size, and recursively build both subtrees.
        */
        for(int i = 0; i < inorder.length; i++){
            middleIndex.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        if(preLeft > preRight){
            return null;
        }

        // get the middle element
        int midEle = preorder[preLeft];
        // build the cur node
        TreeNode cur = new TreeNode(midEle);
        // find the index of the middle element in the inorder array
        int midIndex = middleIndex.get(midEle);
        // get the left boundary and right boundary of arrays
        int leftSize = midIndex - inLeft;
        int rightSize = inRight - midIndex;
        // recursively build the tree
        cur.left = dfs(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, midIndex - 1);
        cur.right = dfs(preorder, preLeft + leftSize + 1, preRight, inorder, midIndex + 1, inRight);
        return cur;
    }
}
