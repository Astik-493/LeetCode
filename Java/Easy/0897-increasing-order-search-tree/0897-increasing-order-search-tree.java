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
    public void inorder(TreeNode root,ArrayList<Integer>ans){
        if(root==null)
            return;

        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)
        return root;

        inorder(root,ans);
        root = new TreeNode(ans.get(0));

        TreeNode curr = root;
        for(int i=1;i<ans.size();i++){
            curr.right = new TreeNode(ans.get(i));
            curr = curr.right;
        }
        return root;
    }
}