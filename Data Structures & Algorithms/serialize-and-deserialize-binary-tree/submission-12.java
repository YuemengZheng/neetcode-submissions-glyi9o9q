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
        serializeHelper(root, list);
        return String.join(",", list);
    }
    private void serializeHelper(TreeNode root, List<String> list) {
        if(root == null) {
            list.add("N");
            return;
        }

        list.add(String.valueOf(root.val));
        serializeHelper(root.left, list);
        serializeHelper(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(",");
        return deserialize(list, new int[]{0});
    }

    private TreeNode deserialize(String[] list, int[] index) {
        if(list[index[0]].equals("N")) {
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list[index[0]++]));
        root.left = deserialize(list, index);
        root.right = deserialize(list, index);
        return root;
    }
}
