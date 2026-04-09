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
    // We want to turn a tree into a string (serialize) 
    // and then rebuild the same tree from that string (deserialize).
    // when a node exists, record its value
    // when a child is null, recors"N"
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
        return  String.join(",", res);
    }
    private void dfsSerialize(TreeNode node, List<String> res){
        if(node == null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfsDeserialize(vals, i);
    }
    private TreeNode dfsDeserialize(String[] vals, int[] i){
        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfsDeserialize(vals, i);
        node.right = dfsDeserialize(vals, i);
        return node;
    }
}
