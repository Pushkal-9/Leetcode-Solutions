// Last updated: 04/04/2025, 19:25:29
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
    private int max = 0;
    public int amountOfTime(TreeNode root, int start) {
       HashMap<Integer,List<Integer>> map = new HashMap<>(); 
       HashSet<Integer> set = new HashSet<>();

       buildAdj(root,map);

       dfs(start,map,set,0);

       return max;
    }

    public void dfs(int root,HashMap<Integer,List<Integer>> map, HashSet<Integer> vis, int level){
        vis.add(root);

        max=Math.max(max,level);

        for(int neighbor : map.get(root)){
            if(!vis.contains(neighbor)){
                dfs(neighbor, map, vis, level+1);
            }
        }
    }

    public void buildAdj(TreeNode root, HashMap<Integer,List<Integer>> map){
        if(root==null){
            return ;
        }

        if(!map.containsKey(root.val)){
            map.put(root.val, new ArrayList<>());
        }

        if(root.left!=null){
            map.get(root.val).add(root.left.val);
            if(!map.containsKey(root.left.val)){
                map.put(root.left.val, new ArrayList<>());
            }
            map.get(root.left.val).add(root.val);
            buildAdj(root.left,map);
        }

        if(root.right!=null){
            map.get(root.val).add(root.right.val);
            if(!map.containsKey(root.right.val)){
                map.put(root.right.val, new ArrayList<>());
            }
            map.get(root.right.val).add(root.val);
            buildAdj(root.right,map);
        }

    }
}