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
    boolean valid = true;
    public int check(TreeNode root){
         if(root==null)
        return 0;

        if(root.left==null && root.right==null)
        return root.val;

        int left = check(root.left);
        int right = check(root.right);

        if(root.val!= left+right)
        valid = false;

        return root.val+left+right;

    }
    public boolean checkTree(TreeNode root) {
       check(root);
       return valid;
    }
}