// Last updated: 19/06/2025, 14:38:06
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
        Queue<Pair> q = new LinkedList<>();

        Map<Integer,List<Integer>> map = new HashMap<>();

        q.add(new Pair(root,0));

        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){

                Pair pair = q.poll();

                TreeNode node = pair.node;
                int level = pair.level;

                if(!map.containsKey(level)){
                    map.put(level, new ArrayList<>());
                }
                map.get(level).add(node.val);

                min = Math.min(min,level);
                max = Math.max(max,level);


                if(node.left!=null){
                    q.add(new Pair(node.left, level-1));
                }

                if(node.right!=null){
                    q.add(new Pair(node.right, level+1));
                }

            }
        }

        for(int i = min; i<=max;i++){
            if(map.containsKey(i)){
                result.add(map.get(i));
            }
        }

        return result;
    }
}

class Pair{

    TreeNode node;
    int level;

    public Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}