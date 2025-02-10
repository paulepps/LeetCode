class MinStack {

    Stack<Node> s;

    class Node {
        int val;
        int min;
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    public MinStack() {
        this.s = new Stack<Node>();
    }
    
    public void push(int val) {
        if (s.isEmpty()) {
            this.s.push(new Node(val, val));
        } else {
            int min = Math.min(getMin(), val);
            this.s.push(new Node(val, min));
        }
    }
    
    public void pop() {
        this.s.pop();
    }
    
    public int top() {
        return this.s.peek().val;
    }
    
    public int getMin() {
        return this.s.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */