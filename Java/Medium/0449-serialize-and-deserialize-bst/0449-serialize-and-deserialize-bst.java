/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int i = 0;
    // Encodes a tree to a single string.
     public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }


    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString(); 
        
    }


    // Decodes your encoded data to tree.
    public TreeNode buildBST(int[] arr, int min, int max) {
        if (i == arr.length || arr[i] < min || arr[i] > max)
            return null;
        TreeNode root = new TreeNode(arr[i++]);

        root.left = buildBST(arr, min, root.val);
        root.right = buildBST(arr, root.val, max);

        return root;
    } 


    public TreeNode deserialize(String data) {
        if (data.isEmpty())
                return null;

        String[] arr = data.split(",");
        int[] nums = new int[arr.length];

        for (int j = 0; j < arr.length; j++) 
            nums[j] = Integer.parseInt(arr[j]);
        
        i = 0;
        return buildBST(nums, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;