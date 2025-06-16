// Last updated: 16/06/2025, 16:07:27
class LRUCache {

    int capacity;
    int size;
    Node head, tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        map = new HashMap<>();

        head.next = tail;
        tail.prev = head;

    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void addToHead(Node node){
        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
    }

    public void removeFromTail(){
        Node prev = tail.prev;
        removeNode(prev);
        map.remove(prev.key);
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size()==capacity){
                removeFromTail();
            }
            Node node = new Node(key,value);
            map.put(key,node);
            addToHead(node);
            return;
        }

        Node node = map.get(key);
        node.val = value;
        moveToHead(node);
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */