// Last updated: 23/05/2025, 00:49:05
class MyCircularDeque {
    int capacity;
    Node head, tail;
    int size;

    class Node{
        int val;
        Node prev;
        Node next;

        public Node(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = new Node(-1);
        this.tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if(size>=capacity){
            return false;
        }

        Node node = new Node(value);
        Node next =head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;

        size++;

        return true;
    }
    
    public boolean insertLast(int value) {
        if(size>=capacity){
            return false;
        }

        Node node = new Node(value);
        Node prev = tail.prev;
        node.next = tail;
        node.prev = prev;
        prev.next = node;
        tail.prev = node;

        size++;

        return true;
    }
    
    public boolean deleteFront() {
        if(size==0){
            return false;
        }

        Node next = head.next.next;
        next.prev = head;
        head.next = next;

        size--;

        return true;
        
    }
    
    public boolean deleteLast() {
        if(size==0){
            return false;
        }

        Node prev = tail.prev.prev;
        prev.next = tail;
        tail.prev = prev;

        size--;

        return true;        
    }
    
    public int getFront() {
        if(size==0){
            return -1;
        }

        return head.next.val;
    }
    
    public int getRear() {
        if(size==0){
            return -1;
        }

        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */