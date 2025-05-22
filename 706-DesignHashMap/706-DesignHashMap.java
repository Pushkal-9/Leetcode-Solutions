// Last updated: 22/05/2025, 14:31:33
class MyHashMap {
    int SIZE;
    Node[] buckets;
    public MyHashMap() {
        this.SIZE = 2069;
        this.buckets = new Node[SIZE];
    }

    public int hashcode(int key){
        return key%SIZE;
    }
    
    public void put(int key, int value) {
        int hashcode = hashcode(key);
        Node head = new Node(key,value);

        Node node = buckets[hashcode];

        while(node!=null){
            if(node.key == key){
                node.val = value;
                return;
            }
            node=node.next;
        }

        node = buckets[hashcode];

        head.next = node;

        buckets[hashcode] = head;
    }
    
    public int get(int key) {
        int hashcode = hashcode(key);

        if(buckets[hashcode]==null){
            return -1;
        }

        Node node = buckets[hashcode];

        while(node!=null){
            if(node.key == key){
                return node.val;
            }
            node=node.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int hashcode = hashcode(key);

        if(buckets[hashcode]==null){
            return;
        }

        Node node = buckets[hashcode];

        if(node.key == key){
            buckets[hashcode] = node.next;
            return;
        }

        while(node.next!=null){
            if(node.next.key == key){
                node.next = node.next.next;
                return;     
            }
            node=node.next;
        }
    }
}

class Node{
    int key;
    int val;
    Node next;

    public Node(int key,int val){
        this.key=key;
        this.val=val;
        this.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */