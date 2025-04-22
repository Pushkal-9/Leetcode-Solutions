// Last updated: 22/04/2025, 18:44:05
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
    List<Integer> result;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>(); 
       constructAdj(root,adj);

       result = new ArrayList<>();

       Queue<Integer> q = new LinkedList<>();

       q.add(target.val);

       int level = -1;

       Set<Integer> vis = new HashSet<>();
       vis.add(target.val);

       while(!q.isEmpty()){
        int size = q.size();
        level++;
        for(int i=0;i<size;i++){
            int node = q.poll();
            if(level==k){
                result.add(node);
            }
            for(int next : adj.get(node)){
                if(!vis.contains(next)){
                    q.add(next);
                    vis.add(next);
                }
            }
        }

       }

       return result;

    }


    public void constructAdj(TreeNode root, HashMap<Integer, ArrayList<Integer>> adj){
        if(root==null){
            return ;
        }

        if(!adj.containsKey(root.val))
            adj.put(root.val, new ArrayList<>());

        if(root.left!=null){
            adj.get(root.val).add(root.left.val);
            if(!adj.containsKey(root.left.val)){
                adj.put(root.left.val, new ArrayList<>());
            }
            adj.get(root.left.val).add(root.val);
        }

        if(root.right!=null){
            adj.get(root.val).add(root.right.val);
            if(!adj.containsKey(root.right.val)){
                adj.put(root.right.val, new ArrayList<>());
            }
            adj.get(root.right.val).add(root.val);
        }

        constructAdj(root.left,adj);
        constructAdj(root.right,adj);
    }
}