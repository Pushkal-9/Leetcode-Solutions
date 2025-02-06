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
    public List<Integer> rightSideView(TreeNode root) {
               Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if(root==null){
            return list;
        }

        q.add(root);
        q.add(null);

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

        List<Integer> rightView = new ArrayList<>();

        for(List<Integer> l : res){
            rightView.add(l.get(l.size()-1));
        }

        return rightView;
    }
}