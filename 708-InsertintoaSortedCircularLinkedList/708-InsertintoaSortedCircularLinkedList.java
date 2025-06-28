// Last updated: 28/06/2025, 18:41:59
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node node = head;

        while(node.next != head){
            if(node.val <= node.next.val){
                if(node.val <= insertVal && insertVal <= node.next.val){
                    break;
                }
            }
            else{
                if(node.val <= insertVal || insertVal <= node.next.val){
                    break;
                }
            }

            node = node.next;
        }

        Node next = node.next;
        node.next = new Node(insertVal, next);

        return head;
    }
}