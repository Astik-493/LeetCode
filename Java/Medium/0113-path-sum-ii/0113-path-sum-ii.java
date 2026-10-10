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
     private void dfs(TreeNode node,int targetSum,List<Integer> path,List<List<Integer>>ans) {
        if (node == null) return ;

        path.add(node.val);
        targetSum -= node.val;

        if(node.left==null && node.right==null){
            if(targetSum==0)
            ans.add(new ArrayList<>(path));
        }
        else{
            dfs(node.left,targetSum,path,ans);
            dfs(node.right,targetSum,path,ans);
            }
        path.remove(path.size()-1);
}    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
          dfs(root,targetSum,path,ans);
          return ans;
    }
}