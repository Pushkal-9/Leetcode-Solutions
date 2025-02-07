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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return maxSum;
    }

    public int max(TreeNode root){
        if(root==null){
            return 0;
        }


        int case1 = Math.max(0, max(root.right));
        //int case2 = Math.max(Math.max(max(root.left,0), max(root.right,0)),root.val + max(root.left,0)+max(root.right,0));
        int case2 = Math.max(0,max(root.left));

        maxSum = Math.max(maxSum,root.val + case1 + case2);

        return Math.max(case1,case2)+root.val;
    }
}