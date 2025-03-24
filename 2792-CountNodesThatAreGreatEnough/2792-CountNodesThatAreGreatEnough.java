// Last updated: 23/03/2025, 23:20:07
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
    Integer count = 0;
    public int countGreatEnoughNodes(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));

        kLeast(root,pq,k);

        return count;
    }

    public void kLeast(TreeNode root, PriorityQueue<Integer> pq, int k){
        if(root==null){
            return;
        }

        PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> (b-a));
        PriorityQueue<Integer> right = new PriorityQueue<>((a,b) -> (b-a));

        kLeast(root.left,left,k);
        kLeast(root.right,right,k);

        pq.add(root.val);

        pq = merge(left,right,pq,k);

        if(pq.size()>=k && pq.peek()<root.val){
            //System.out.println("printing");
            count++;
        }
        
    }

    public PriorityQueue<Integer> merge(PriorityQueue<Integer> left, PriorityQueue<Integer> right, PriorityQueue<Integer> pq, int k){
        while(!left.isEmpty()){
            pq.add(left.poll());
        }

        while(!right.isEmpty()){
            pq.add(right.poll());
        }

        while(pq.size()>k){
            pq.poll();
        }

        return pq;
    }
}