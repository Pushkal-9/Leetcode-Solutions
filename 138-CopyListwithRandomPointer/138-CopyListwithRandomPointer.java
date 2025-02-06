/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map1 = new HashMap<>();
        HashMap<Node,Node> map2 = new HashMap<>();

        Node dummy = new Node(-1);
        Node prev = dummy;

        Node current = head;

        while(current!=null){
            Node node = new Node(current.val);
            dummy.next = node;
            dummy=dummy.next;
            map1.put(current,node);
            current=current.next;
        }

        for(Node node : map1.keySet()){
            map2.put(map1.get(node),node);
        }

        current = prev.next;

        while(current!=null){
            current.random = map1.get(map2.get(current).random);
            current=current.next;
        }

        return prev.next;
    }
}