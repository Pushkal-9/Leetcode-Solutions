// Last updated: 24/05/2025, 00:22:49
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
    Integer max;
    public int maxPathSum(TreeNode root) {
        max=root.val;
        maxPath(root);
        return max;
    }

    public int maxPath(TreeNode node){
        if(node==null){
            return 0;
        }

        int left = maxPath(node.left);

        int right = maxPath(node.right);

        int currentMax = Math.max(node.val, Math.max(left,right)+node.val);

        max = Math.max(max,Math.max(currentMax,node.val+left+right));

        return currentMax;
    }
}