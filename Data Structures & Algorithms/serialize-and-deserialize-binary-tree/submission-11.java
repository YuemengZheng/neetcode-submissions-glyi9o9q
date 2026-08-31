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

public class Codec {
    StringBuilder sb;
    int idx;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // preorder traversal contains null
        sb = new StringBuilder();
        serializeHelper(root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        idx = 0;
        return deserializeHelper(arr);
    }

    private void serializeHelper(TreeNode root) {
        if(root == null) {
            sb.append("N,"); 
            return;
        }

        sb.append(root.val).append(",");
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    private TreeNode deserializeHelper(String[] arr) {
        if(arr[idx].equals("N")){
            idx++;
            return null;
        } 

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
        root.left = deserializeHelper(arr);
        root.right = deserializeHelper(arr);
        return root;
    }
}
