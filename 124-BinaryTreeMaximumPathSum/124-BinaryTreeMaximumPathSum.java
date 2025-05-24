// Last updated: 24/05/2025, 00:26:19
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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    public int maxPath(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = Math.max(0, maxPath(root.left));  
        int right = Math.max(0, maxPath(root.right));

        int cur = Math.max(root.val + Math.max(left,right), root.val);
        max = Math.max(max, Math.max(root.val + left + right, cur));
        return root.val + Math.max(left,right);
    }
}