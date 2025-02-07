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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder,inorder,0,0,preorder.length-1);
    }

    public TreeNode construct(int[] preorder, int[] inorder, int rootIndex, int start, int end){

        if(start>end){
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);

        if(start==end){
            return root;
        }

        int index = search(inorder,start,end,root.val);


        root.left = construct(preorder,inorder,index,start,index-1);

        root.right = construct(preorder,inorder,index,index+1,end);

        return root;
    }

    public int search(int[] arr,int start, int end, int target){
        int i=start;
        for(i=start;i<=end;i++){
            if(target==arr[i]){
                return i;
            }
        }

        return i;
    }
}