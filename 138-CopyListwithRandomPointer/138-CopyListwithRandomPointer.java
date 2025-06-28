// Last updated: 28/06/2025, 16:29:20
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
        Map<Node,Node> copyMap = new HashMap<>();

        Node cur = head;

        while(cur != null){
            Node node = new Node(cur.val);
            copyMap.put(cur,node);
            cur = cur.next;
        }

        cur = head;

        while(cur != null){
            Node originalRandom = cur.random;
            Node copyNode = copyMap.get(cur);
            Node copyRandom = copyMap.get(originalRandom);
            copyNode.random = copyRandom;
            copyNode.next = copyMap.get(cur.next);

            cur = cur.next;

        }

        return copyMap.get(head);
    }
}