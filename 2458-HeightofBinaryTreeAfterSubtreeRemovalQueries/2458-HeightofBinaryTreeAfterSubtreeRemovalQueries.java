// Last updated: 22/03/2025, 16:34:24
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
    HashMap<Integer,Integer> lmap = new HashMap<>();
    HashMap<Integer,Integer> rmap = new HashMap<>();
    Integer h;
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] res = new int[queries.length];
        
        h=0;

        heightLeft(root,0);
        h=0;
        heightRight(root,0);

        HashMap<Integer, Integer> max = new HashMap<>();

        for(int i : rmap.keySet()){
            max.put(i,Math.max(rmap.get(i),lmap.get(i)));
        }

        for(int i=0;i<res.length;i++){
            res[i]= max.get(queries[i]);
        }


        return res;
    }

    public int height(TreeNode root, int k){
        if(root==null || root.val==k){
            return 0;
        }

        return 1 + Math.max(height(root.left,k),height(root.right,k));
    }

    public void heightLeft(TreeNode root,int cur){
        if(root==null){
            return;
        }
        lmap.put(root.val,h);
        h = Math.max(cur,h);

        heightLeft(root.left,cur+1);
        heightLeft(root.right,cur+1);

    }

    public void heightRight(TreeNode root,int cur){
        if(root==null){
            return;
        }
        rmap.put(root.val,h);
        h = Math.max(cur,h);
        heightRight(root.right,cur+1);
        heightRight(root.left,cur+1);
    }
}