// Last updated: 15/05/2025, 01:22:22
class MyStack {
    private Queue<Integer> q;
    public MyStack() {
        this.q = new LinkedList<>();
    }
    
    public void push(int x) {
        this.q.add(x);
    }
    
    public int pop() {
        int size = this.q.size();
        for(int i=0;i<size-1;i++){
            this.q.add(this.q.poll());
        }

        return this.q.poll();
    }
    
    public int top() {
        int size = this.q.size();

        for(int i=0;i<size-1;i++){
            this.q.add(this.q.poll());
        }

        int top = this.q.poll();
        this.q.add(top);

        return top; 
    }
    
    public boolean empty() {
        return this.q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */