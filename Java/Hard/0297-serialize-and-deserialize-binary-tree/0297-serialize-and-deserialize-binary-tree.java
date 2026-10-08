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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();        
            if(curr == null){
            sb.append("null,");
            continue;
            }

            sb.append(curr.val).append(",");
            q.add(curr.left);
            q.add(curr.right);
            }
            return sb.toString();
        }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
         return null;

        String[] val = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(val[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(!val[i].equals("null")){
                TreeNode left = new TreeNode(Integer.valueOf(val[i]));
                curr.left = left;
                q.add(left);
            }
            i++;

            if(!val[i].equals("null")){
                TreeNode right = new TreeNode(Integer.valueOf(val[i]));
                curr.right = right;
                q.add(right);
            }
            i++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));