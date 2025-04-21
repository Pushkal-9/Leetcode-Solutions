// Last updated: 20/04/2025, 19:46:36
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }

    public boolean helper(TreeNode node, int target, int cur){
        if(node==null){
            return false;
        }

        cur = cur + node.val;

        if(node.left==null && node.right==null && cur==target){
            return true;
        }

        return helper(node.left, target, cur) || helper(node.right, target, cur );

    }
}