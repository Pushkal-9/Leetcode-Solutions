// Last updated: 29/06/2025, 12:42:21
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        buildAdj(root,adj,null);

        Queue<TreeNode> q = new LinkedList<>();

        q.add(target);

        List<Integer> res = new ArrayList<>();

        int level = 0;

        Set<TreeNode> vis = new HashSet<>();
        vis.add(target);

        while(!q.isEmpty()){
            int size = q.size();

            if(level == k){
                while(!q.isEmpty()){
                    res.add(q.poll().val);
                }
                break;
            }

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                for(TreeNode neigh : adj.get(node)){
                    if(!vis.contains(neigh)){
                        q.add(neigh);
                        vis.add(neigh);
                    }
                }
            }

            level++;
        }

        return res;

    }
    public void buildAdj(TreeNode node, Map<TreeNode, List<TreeNode>> map, TreeNode parent){
        if(node == null){
            return;
        }

        if(!map.containsKey(node)){
            map.put(node, new ArrayList<>());
        }

        if(node.left!=null){
            map.get(node).add(node.left);
        }

        if(node.right!=null){
            map.get(node).add(node.right);
        }

        if(parent!=null){
            map.get(node).add(parent);
        }

        buildAdj(node.left,map,node);
        buildAdj(node.right,map,node);
    }
}