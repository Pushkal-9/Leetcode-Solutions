// Last updated: 28/06/2025, 16:43:01
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node pointer;
    public Node treeToDoublyList(Node root) {
        Node dummy = new Node(-1);
        pointer = dummy;

        if(root == null){
            return root;
        }

        dfs(root);

        Node head = dummy.right;

        pointer.right = head;
        head.left = pointer;

        return head;
    }

    public void dfs(Node node){
        if(node == null){
            return;
        }

        dfs(node.left);
        Node newNode = new Node(node.val);
        pointer.right = newNode;
        newNode.left = pointer;
        pointer = pointer.right;

        dfs(node.right);
    }
}