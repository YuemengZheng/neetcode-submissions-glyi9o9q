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
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfsSerialize(root, list);
        return String.join("#", list);
    }
    private void dfsSerialize(TreeNode root, List<String> list){
        if(root == null){
            list.add("N");
            return;
        }
        
        list.add(String.valueOf(root.val));
        dfsSerialize(root.left, list);
        dfsSerialize(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("#");
        return dfsDeserialize(arr, new int[]{0});    
    }
    private TreeNode dfsDeserialize(String[] arr, int[] curIndex){
        if(arr[curIndex[0]].equals("N")){
            curIndex[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[curIndex[0]]));
        curIndex[0]++;
        root.left = dfsDeserialize(arr, curIndex);
        root.right = dfsDeserialize(arr, curIndex);
        return root;
    }
}
