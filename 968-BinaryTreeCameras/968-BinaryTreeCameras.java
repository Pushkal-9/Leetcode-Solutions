// Last updated: 16/05/2025, 12:38:28
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
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        HashSet<TreeNode> covered = new HashSet<>();

        covered.add(null);
        dfs(root,null,covered);

        return cameras;

    }

    public void dfs(TreeNode node, TreeNode parent, HashSet<TreeNode> covered){
        if(node!=null){
            dfs(node.left,node,covered);
            dfs(node.right,node,covered);

            if((parent==null && !covered.contains(node)) || !covered.contains(node.left) || !covered.contains(node.right)){
                cameras++;

                covered.add(parent);
                covered.add(node);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
}