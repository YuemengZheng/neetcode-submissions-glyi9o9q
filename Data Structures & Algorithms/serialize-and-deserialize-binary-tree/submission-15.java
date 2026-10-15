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
    /*
    For serialize, 
    use preorder DFS to convert the tree to a string, 
    for null node, we use placeholder to represents it. 
    For deserialize, 
    use preorder DFS again to rebuild the tree 
    — when you see a placeholder, return null; 
    otherwise build a node and recursively build its left and right children.
    */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /*
        Use dfs preorder.
        If node is null → append "N".
        Else append node value.
        Recursively process left child, then right child.
        Join list with commas → return string.
        */
        List<String> list = new ArrayList<>();
        dfsSerialize(root, list);
        return String.join(",", list);
    }
    private void dfsSerialize(TreeNode root, List<String> res){
        if(root == null){
            res.add("N");
            return;
        }
        
        res.add(String.valueOf(root.val));
        dfsSerialize(root.left, res);
        dfsSerialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return dfsDeserialize(arr, new int[]{0});
    }
    private TreeNode dfsDeserialize(String[] vals, int[] curIndex){
        if(vals[curIndex[0]].equals("N")){
            curIndex[0]++; // ERROR1
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[curIndex[0]]));
        curIndex[0]++;
        root.left = dfsDeserialize(vals, curIndex);
        root.right = dfsDeserialize(vals, curIndex);
        return root;
    }
    // Since int is a primitive type in Java, it is passed by value, 
    // so changes are not shared across recursive calls. To maintain a shared index, 
    // I wrap it in an array so all recursive calls can update the same reference.
}
