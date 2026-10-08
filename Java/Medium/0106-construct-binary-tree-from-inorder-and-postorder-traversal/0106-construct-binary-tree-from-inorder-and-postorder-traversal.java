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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);

        TreeNode root = build(inorder,0,inorder.length -1,
        postorder,0,postorder.length-1,map);

        return root;
    }


     public TreeNode build(int [] inorder,int inS,int inE,
     int [] postorder,int postS,int postE,HashMap<Integer,Integer>map){

        if(postS>postE || inS>inE)
        return null;

        TreeNode root = new TreeNode(postorder[postE]);
        int inRoot = map.get(root.val);
        int numsleft = inRoot - inS;

        root.left = build(inorder,inS,inRoot-1,postorder,postS,postS+numsleft-1,map);
        root.right = build(inorder,inRoot+1,inE,postorder,postS+numsleft,postE-1,map);

        return root;
     }
}