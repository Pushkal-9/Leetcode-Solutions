// Last updated: 22/03/2025, 15:28:54
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
    int ans=0;
    HashSet<TreeNode> nodes;
    public int minCameraCover(TreeNode root) {
        nodes = new HashSet<>();
        nodes.add(null);
        dfs(root,null);
        return ans;
    }

    public void dfs(TreeNode node, TreeNode parent){
        if(node!=null){
            dfs(node.left,node);
            dfs(node.right,node);

            if((parent==null && !nodes.contains(node)) || !nodes.contains(node.left) || !nodes.contains(node.right)){
                ans++;
                if(parent!=null){
                    nodes.add(parent);
                }
                if(node!=null){
                    nodes.add(node);
                }
                if(node.left!=null){
                    nodes.add(node.left);
                }
                if(node.right!=null){
                    nodes.add(node.right);
                }
            }
        }
    }
}