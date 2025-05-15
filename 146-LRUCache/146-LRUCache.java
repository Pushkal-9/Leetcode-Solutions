// Last updated: 15/05/2025, 02:21:38
class LRUCache {
    HashMap<Integer,Node> map;
    Node head, tail;
    Integer capacity;

    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key=key;
            this.val=val;
            prev=null;
            next=null;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public Node removeNode(int key){
        Node node = map.get(key);

        if(node==null){
            return node;
        }

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        map.remove(key);
        return node;
    }

    public void moveToHead(int key){
        Node node = removeNode(key);
        map.put(key,node);
        addToHead(node);
    }

    public void addToHead(Node node){
         Node next = head.next;
        node.next = next;
        next.prev = node;
        node.prev = this.head;
        this.head.next = node;       
    }

    public Node removeTail(){
        return removeNode(this.tail.prev.key);
    }


    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        moveToHead(key);

        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            moveToHead(key);
            return;
        }

        Node node = new Node(key, value);

        map.put(key,node);
        addToHead(node);

        if(this.capacity<map.size()){
            Node last = removeTail();
            map.remove(last.key);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */