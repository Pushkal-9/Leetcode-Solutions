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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root==null){
            return res;
        }

        q.add(root);
        q.add(null);

        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node==null){
                res.add(list);
                if(q.isEmpty()){
                    break;
                }
                list = new ArrayList<>();
                q.add(null);
            }
            else{
                list.add(node.val);

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }

        return res;
    }
}