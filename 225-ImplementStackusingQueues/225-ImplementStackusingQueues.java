// Last updated: 15/05/2025, 01:25:31
class MyStack {
    private Queue<Integer> q;
    Integer top;
    public MyStack() {
        this.q = new LinkedList<>();
    }
    
    public void push(int x) {
        this.q.add(x);
        this.top = x;
    }
    
    public int pop() {
        int size = this.q.size();
        for(int i=0;i<size-1;i++){
            this.top = this.q.poll();
            this.q.add(top);
        }

        return this.q.poll();
    }
    
    public int top() {

        return this.top; 
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