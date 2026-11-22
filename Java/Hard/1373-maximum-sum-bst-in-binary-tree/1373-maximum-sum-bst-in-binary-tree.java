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
    class Info {
        int sum;
        int min;
        int max;
        int maxBSTSum;

        Info(int sum, int min, int max, int maxBSTSum) {
            this.sum = sum;
            this.min = min;
            this.max = max;
            this.maxBSTSum = maxBSTSum;
        }
    }
    public int maxSumBST(TreeNode root) {
        return helper(root).maxBSTSum;
    }
    public Info helper(TreeNode root) {
        if(root==null)
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Info left= helper(root.left);
        Info right = helper(root.right);

        if (root.val > left.max && root.val < right.min) {
            int sum = left.sum + right.sum + root.val;
            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);

            return new Info(sum, min, max,Math.max(sum,Math.max(left.maxBSTSum, right.maxBSTSum)));
        }
        return new Info(0,Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxBSTSum,right.maxBSTSum));
    }
}