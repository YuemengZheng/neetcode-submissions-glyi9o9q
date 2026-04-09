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
    // *********TC: O(n), SC: O(n)*********
    // We want to turn a tree into a string (serialize) 
    // and then rebuild the same tree from that string (deserialize).
    // when a node exists, record its value
    // when a child is null, use n to represent null
    // so the string can uniquely represents a tree

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /*
        Use dfs preorder.
        If node is null → append "N".
        Else append node value.
        Recursively process left child, then right child.
        Join list with commas → return string.
        */
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
    }
    private void dfsSerialize(TreeNode root, List<String> res){
        if(root == null){
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));// ?
        dfsSerialize(root.left, res);
        dfsSerialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        return dfsDeserialize(vals, new int[]{0});
    }
    private TreeNode dfsDeserialize(String[] vals, int[] curIndex){
        if(vals[curIndex[0]].equals("N")){
            curIndex[0]++;
            return null;
        }

        TreeNode cur = new TreeNode(Integer.parseInt(vals[curIndex[0]]));
        curIndex[0]++;
        cur.left = dfsDeserialize(vals, curIndex);
        cur.right = dfsDeserialize(vals, curIndex);
        return cur;
    }
    // Since int is a primitive type in Java, it is passed by value, 
    // so changes are not shared across recursive calls. To maintain a shared index, 
    // I wrap it in an array so all recursive calls can update the same reference.
}
