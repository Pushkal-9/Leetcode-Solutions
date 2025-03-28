// Last updated: 28/03/2025, 15:23:45
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();

        vertical(root,0,map,0);

       List<Integer> keySet = new ArrayList<>(map.keySet());
    Collections.sort(keySet);

       List<List<Integer>> res = new ArrayList<>();

        for(int level : keySet){
            List<Integer> list = new ArrayList<>();
            List<Pair> pairList = map.get(level);
        Collections.sort(pairList,(a,b) -> {
            if(a.height!=b.height){
                return a.height-b.height;
            }

            return 0;
        });
            for(Pair p : pairList){
                list.add(p.value);
            }
            res.add(list);
        } 

        return res;
    }

    public void vertical(TreeNode root, int level, HashMap<Integer,List<Pair>> map, int height){
        if(root==null){
            return;
        }

        if(!map.containsKey(level)){
            map.put(level,new ArrayList<>());
        }

        map.get(level).add(new Pair(root.val,height));

        vertical(root.left,level-1,map, height+1);
        vertical(root.right,level+1,map, height+1);
    }
}

class Pair{
    int value;
    int height;

    public Pair(int value, int height){
        this.value=value;
        this.height=height;
    }
}