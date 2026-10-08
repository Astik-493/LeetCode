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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);

       TreeNode root = build(preorder,0,preorder.length - 1,
       inorder,0,inorder.length -1,map);

       return root;
    }

    public TreeNode build(int []preorder,int preS,int preE,
     int [] inorder,int inS,int inE,HashMap<Integer,Integer>map){

        if(preS>preE || inS>inE)
        return null;

        TreeNode root = new TreeNode(preorder[preS]);
        int inRoot = map.get(root.val);
        int numsleft = inRoot - inS;

        root.left = build(preorder,preS+1,preS+numsleft,inorder,inS,inRoot-1,map);
        root.right = build(preorder,preS+numsleft+1,preE,inorder,inRoot+1,inE,map);

        return root;
    }
}