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
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return sum;
    }

    public int max(TreeNode root){
        if(root==null){
            return 0;
        }

        int case1 = Math.max(0,max(root.left));
        int case2 = Math.max(0,max(root.right));

        sum = Math.max(sum,root.val+case1+case2);

        return Math.max(case1,case2) + root.val;    
    }
}