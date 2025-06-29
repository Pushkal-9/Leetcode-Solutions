// Last updated: 28/06/2025, 23:55:25
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
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();

        this.leftMostInorder(root);
    }

    public void leftMostInorder(TreeNode root){
        while(root!=null){
            this.stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode top = this.stack.pop();

        if(top.right!=null){
            this.leftMostInorder(top.right);
        }

        return top.val;
    }
    
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */