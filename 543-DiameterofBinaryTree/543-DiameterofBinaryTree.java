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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        int max1 = Math.max(left,right);

        int current = height(root.left) + height(root.right);

        return Math.max(current, max1);
    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }

        return 1 + Math.max(height(root.left),height(root.right));
    }
}